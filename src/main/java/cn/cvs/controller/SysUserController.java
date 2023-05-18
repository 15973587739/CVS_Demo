package cn.cvs.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/18 10:03
 **/
@Controller
@RequestMapping(value = "/user")
public class SysUserController extends AbstractController {
    private Logger logger = Logger.getLogger(SysUserController.class);

    @RequestMapping(value = "/view" , method = RequestMethod.GET)
    public String view() throws Exception {
        logger.info("查询用户详细");
        return null;
    }

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public String save() throws Exception {
        logger.info("保存用户详细");
        return null;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }
}
