package cn.cvs.controller;

import cn.cvs.pojo.TSysUser;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/18 9:38
 **/
@Controller
@RequestMapping(value = "/hello")
public class HelloController extends AbstractController {
    Logger logger = Logger.getLogger(HelloController.class);
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Spring MVC 框架搭建成功。");
        return new ModelAndView("hello");
    }

    @RequestMapping(value = "/hello")
    public String hello() throws Exception {
        System.out.println("Spring MVC 框架搭建成功");
        return "hollo";
    }
    @RequestMapping(value = "/hello2")
    public String hello2() throws Exception {
        System.out.println("hello控制器下的另一个接口");
        return "hollo";
    }
    @RequestMapping(value = "/hello3")
    public String hello3(@RequestParam(required = false) String realName) throws Exception {
        logger.info("你好"+realName+"欢迎来到Spring MVC 课堂");
        return "hollo";
    }
    @RequestMapping(value = "/hello4")
    public String hello4(@RequestParam(value = "userName",required = false) String realName) throws Exception {
        logger.info("你好"+realName+"欢迎来到Spring MVC 课堂");
        return "hollo";
    }
    @RequestMapping(value = "/hello5")
    public ModelAndView hello5(@RequestParam String realName) throws Exception {
        logger.info("你好"+realName+"欢迎来到Spring MVC 课堂");
        ModelAndView mv = new ModelAndView();
        mv.addObject("realName",realName);
        mv.setViewName("holle");
        return mv;
    }

    @RequestMapping(value = "/hello6")
    public String hello6(Model model, @RequestParam(value = "userName",required = false) String realName) throws Exception {
        logger.info("你好"+realName+"欢迎来到Spring MVC 课堂");
        model.addAttribute("realName",realName);
        return "hello";
    }
    @RequestMapping(value = "/hello7")
    public String hello7(Model model, @RequestParam(value = "userName",required = false) String realName) throws Exception {
        logger.info("你好"+realName+"欢迎来到Spring MVC 课堂");
        model.addAttribute("realName",realName);
        model.addAttribute(realName);
        return "hello";
    }
    @RequestMapping(value = "/hello8")
    public String hello8(Model model, @RequestParam(value = "userName",required = false) String realName) throws Exception {
        logger.info("你好"+realName+"欢迎来到Spring MVC 课堂");
        TSysUser sysUser = new TSysUser();
        sysUser.setRealName(realName);
        model.addAttribute("realName",realName);
        model.addAttribute(realName);
        return "hello";
    }

    @RequestMapping(value = "/hello9")
    public String hello(Map<String,Object> map, @RequestParam(value = "userName",required = false) String realName) throws Exception {
        logger.info("你好"+realName+"欢迎来到Spring MVC 课堂");
        map.put("realName",realName);
        return "hello";
    }
}
