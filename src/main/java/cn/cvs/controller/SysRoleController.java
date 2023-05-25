package cn.cvs.controller;

import cn.cvs.pojo.TSupplier;
import cn.cvs.pojo.TSysRole;
import cn.cvs.service.TSupplierService;
import cn.cvs.service.TSysRoleService;
import cn.cvs.service.impl.TSupplierServiceImpl;
import cn.cvs.service.impl.TSysRoleServiceImpl;
import cn.cvs.utils.Constants;
import cn.cvs.utils.Pager;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/18 10:03
 **/
@Controller
@RequestMapping(value = "/sysRole")
public class SysRoleController {
    private Logger logger = Logger.getLogger(SysRoleController.class);

    @Autowired
    TSysRoleService service ;

    @GetMapping("/list")
    public String getList(Model model){
        List<TSysRole> roleList = null;
        try {
            roleList = service.getSysRoleList("");
            model.addAttribute("roleList",roleList);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("表接口访问失败");
            return "redirect:/sysRole/toSysError";
        }
        return "sysRole/list";
    }

    @RequestMapping(value = "/view")
    public String view() throws Exception {
        logger.info("查询员工详细");
        return null;
    }

}
