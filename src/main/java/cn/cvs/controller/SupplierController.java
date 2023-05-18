package cn.cvs.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(value = "/supplier")
public class SupplierController extends AbstractController {
    private Logger logger = Logger.getLogger(SupplierController.class);

    @RequestMapping(value = "/view")
    public String view() throws Exception {
        logger.info("查询购物商详细");
        return null;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }
}
