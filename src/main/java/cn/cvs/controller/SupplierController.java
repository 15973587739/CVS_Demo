package cn.cvs.controller;

import cn.cvs.pojo.TSupplier;
import cn.cvs.pojo.TSysRole;
import cn.cvs.pojo.TSysUser;
import cn.cvs.service.TSupplierService;
import cn.cvs.service.impl.TSupplierServiceImpl;
import cn.cvs.utils.Constants;
import cn.cvs.utils.Pager;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/18 10:03
 **/
@Controller
@RequestMapping(value = "/sup")
public class SupplierController{
    private Logger logger = Logger.getLogger(SupplierController.class);

    @Autowired
    TSupplierService service ;

    @GetMapping("/list")
    public String getList(Model model, String querySupCode, String querySupName, @RequestParam(defaultValue = "1")Integer pageIndex){
        List<TSupplier> supplierList = null;
        try {
            int pageSize = Constants.pageSize;
            TSupplier sup = new TSupplier();
            sup.setSupCode(querySupCode);
            sup.setSupName(querySupName);

            int totalCount = (int) service.count(sup);

            if (totalCount < 0){
                totalCount = 1;
            }
            Pager page = new Pager(totalCount, pageSize,pageIndex);

            int totalPageCount = page.getPageCount();
            if (pageIndex > totalPageCount){
                pageIndex = totalPageCount;
                throw  new RuntimeException("页码不正确");
            }

            supplierList = service.queryAllByLimit(sup,pageIndex,pageSize);
            model.addAttribute("supplierList",supplierList);
            model.addAttribute("pageIndex", pageIndex);
            model.addAttribute("totalPageCount", totalPageCount);
            model.addAttribute("totalCount", totalCount);
            model.addAttribute("querySupName",querySupName);
            model.addAttribute("querySupCode",querySupCode);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("供货商列表接口访问失败");
            return "redirect:/sysError";
        }
        return "supplier/list";
    }

    @GetMapping("/view/{supId}")
    public String view(@PathVariable String supId, Model model){
        logger.info("单查询用户id = "+supId);
        logger.info("查询购物商详细");
        model.addAttribute("supplier", service.queryById(Long.valueOf(supId)));
        return "supplier/view";
    }

    @RequestMapping("/toUpdate/{supId}")
    public String toUpdate(@PathVariable String supId, Model model ) {
        logger.info("单查询用户id = "+supId);
        model.addAttribute("supplier", service.queryById(Long.valueOf(supId)));
        return "supplier/update";
    }
    @PostMapping("/update")
    public String update(TSupplier supplier, HttpSession session ,Model model ) {
        logger.info("单修改用户信息");
        supplier.setCreatedUserId(((TSysUser)session.getAttribute(Constants.USER_SESSION)).getId());
        supplier.setUpdatedTime(new Date());
        if (service.modify(supplier) > 0) {
            return "redirect:/sup/list";
        }
        model.addAttribute("supplier", supplier);
        return "supplier/add";
    }
}
