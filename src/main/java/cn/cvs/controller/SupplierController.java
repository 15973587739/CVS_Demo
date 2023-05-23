package cn.cvs.controller;

import cn.cvs.pojo.TSupplier;
import cn.cvs.pojo.TSysRole;
import cn.cvs.pojo.TSysUser;
import cn.cvs.service.TSupplierService;
import cn.cvs.service.impl.TSupplierServiceImpl;
import cn.cvs.utils.Constants;
import cn.cvs.utils.Pager;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/18 10:03
 **/
@Controller
@RequestMapping(value = "/supplier")
public class SupplierController{
    private Logger logger = Logger.getLogger(SupplierController.class);

    TSupplierService service = new TSupplierServiceImpl();

    @GetMapping("/list")
    public String getList(Model model, String querySupCode, String querySupName, @RequestParam(defaultValue = "1")Integer pageIndex){
        List<TSupplier> supplierList = null;
        try {
            int pageSize = Constants.pageSize;
            TSupplier sup = new TSupplier();
            sup.setSupCode(querySupCode);
            sup.setSupName(querySupName);
            Long totalCount = service.count(sup);

            Pager page = new Pager();
            page.setPageNo(pageIndex);
            page.setPageSize(pageSize);
            page.setPageCount(Math.toIntExact(totalCount));

            int totalPageCount = page.getRowCount();
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
            return "redirect:/supplier/toSysError";
        }
        return "supplier/list";
    }

    @RequestMapping(value = "/view")
    public String view() throws Exception {
        logger.info("查询购物商详细");
        return null;
    }

}
