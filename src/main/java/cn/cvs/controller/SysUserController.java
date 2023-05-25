package cn.cvs.controller;

import cn.cvs.pojo.TSysRole;
import cn.cvs.pojo.TSysUser;
import cn.cvs.service.TSysRoleService;
import cn.cvs.service.TSysUserService;
import cn.cvs.service.impl.TSysRoleServiceImpl;
import cn.cvs.service.impl.TSysUserServiceImpl;
import cn.cvs.utils.Constants;
import cn.cvs.utils.Pager;
import com.mysql.cj.Session;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.commons.io.FilenameUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/18 10:03
 **/
@Controller
@RequestMapping(value = "/user")
public class SysUserController {
    private Logger logger = Logger.getLogger(SysUserController.class);
    private ArrayList<TSysUser> sysUsers = new ArrayList<TSysUser>();
    private ArrayList<TSysUser> queryUsers = new ArrayList<TSysUser>();
    @Autowired
    TSysUserService service;
    @Autowired
    TSysRoleService roleService;

    @RequestMapping(value="/toLogin")
    public String login(){
        logger.info("跳转到登录界面");
        return "login";
    }

    @RequestMapping("/login")
    public String doLogin(HttpServletRequest request, HttpSession session, @RequestParam String account , @RequestParam String password){
        logger.info("登录方法");
        TSysUser sysUser = service.login(account, password);
        if (sysUser != null) {
            session.setAttribute(Constants.USER_SESSION,sysUser);
            return "redirect:/user/toMain";
        }else {
            request.setAttribute("error","用户密码不正确");
            return "login";
        }
    }
    @RequestMapping("/toMain")
    public String toMain(HttpSession session) {
        if (session.getAttribute(Constants.USER_SESSION)==null){
            return "redirect:/user/toLogin";
        }
        logger.info("跳转到主页");
        return "frame";
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public String handlerException(RuntimeException e,HttpServletRequest request){
        request.setAttribute("e",e);
        return "error";
    }

    @RequestMapping("/exLogin")
    public String exLogin(@RequestParam String account ,@RequestParam String password){
        TSysUser user = service.login(account,password);
        if (user==null){
            throw new RuntimeException("用户名或密码不正确！");
        }
        return "redirect:/user/toMain";
    }
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

    @GetMapping("/list")
    public String getUserList(Model model,String queryRealName,Integer queryRoleId, @RequestParam(defaultValue = "1")Integer pageIndex){
        List<TSysUser> userList = null;
        try {
            int pageSize = Constants.pageSize;
            TSysUser user = new TSysUser();
            user.setRealName(queryRealName);
            user.setRoleId(queryRoleId);
            int totalCount = (int) service.count(user);
            if (totalCount < 0){
                totalCount = 1;
            }
            Pager page = new Pager(totalCount, pageSize,pageIndex);

            int totalPageCount = page.getPageCount();
            if (pageIndex > totalPageCount){
                pageIndex = totalPageCount;
                throw  new RuntimeException("页码不正确");
            }
            userList = service.selectPageList(queryRealName, queryRoleId,pageIndex,pageSize);
            model.addAttribute("userList",userList);
            List<TSysRole> roleList = null;
            roleList = roleService.getSysRoleList("");
            model.addAttribute("roleList", roleList);
            model.addAttribute("pageIndex", pageIndex);
            model.addAttribute("totalPageCount", totalPageCount);
            model.addAttribute("totalCount", totalCount);
            model.addAttribute("queryRealName",queryRealName);
            model.addAttribute("queryRoleId",queryRoleId==null?0:queryRoleId);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表接口访问失败");
            return "redirect:/sysError";
        }
        return "sysUser/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model){
        logger.info("单查询用户id = "+id);
        model.addAttribute("user", service.queryById(Long.valueOf(id)));
        return "sysUser/view";
    }





//    添加
    @GetMapping("/toAdd")
    public String toAdd(@ModelAttribute("sysUser")TSysUser sysUser){
        return "sysUser/add";
    }
    @PostMapping("/add")
    public String add(TSysUser user,HttpSession session){
        user.setCreatedUserId(((TSysUser)session.getAttribute(Constants.USER_SESSION)).getId());
        if (service.insert(user)>0){
            return "redirecet:/user/list";
        }
        return "sysUser/add";
    }
//    @PostMapping("/add")
//    public String add(TSysUser user, HttpSession session, HttpServletRequest request,@RequestParam(value = "attachs",required = false)MultipartFile[] files){
//        String idPicPath = null;
//        String workPath = null;
//        String errorInfo = null;
//        Boolean flag = null;
//        String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator + "upload files");
//        logger.info("path:"+path);
//        for (int i = 0; i < files.length; i++){
//            MultipartFile attach = files[i];
//            if (!attach.isEmpty()) {
//                if (i==0){
//                    errorInfo = "uploadFileError";
//                }else if (i == 1){
//                    errorInfo = "uploadWpError";
//                }
//                String oldFileName = attach.getOriginalFilename();
//                logger.info("oldFileName:"+oldFileName);
//                String prefix = FilenameUtils.getExtension(oldFileName);
//                logger.info("prefix:"+prefix);
//                int fileSize = 500000;
//                logger.info("上传文件大小:"+attach.getSize() / 1024+" KB");
//                if (attach.getSize()>fileSize){
//                    request.setAttribute(errorInfo, "文件大小超出限制 5M");
//                    flag = false;
//                }else if (prefix.equalsIgnoreCase("jpeg")|| prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("gif")|| prefix.equalsIgnoreCase("png")) {
//                    String fileName = System.currentTimeMillis() + "."+FilenameUtils.getExtension(oldFileName);
//
//                    logger.info("fileName:"+fileName);
//                    File targetFile = new File(path);
//                    if (!targetFile.exists()) {
//                        targetFile.mkdirs();
//                    }
//                    try {
//                        attach.transferTo(new File(targetFile,fileName));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        request.setAttribute(errorInfo, "文件上传失败");
//                        flag = false;
//                        throw new RuntimeException(e);
//                    }
//                    if (i == 0) {
//                        idPicPath = File.separator + "statics"+File.separator+"upload files"+File.separator+fileName;
//                    }else if(i == 1) {
//                        workPath = File.separator+"statics"+File.separator + "upload files"+File.separator + fileName;
//                    }
//                    logger.info("idPicPath:"+idPicPath);
//                    logger.info("workPicPath"+workPath);
//                }else {
//                    request.setAttribute(errorInfo, "图片类型不正确");
//                    flag = false;
//                }
//            }
//        }
//        if (flag) {
//            user.setCreatedUserId(((TSysUser) session.getAttribute(Constants.USER_SESSION)).getId());
//
//            user.setCreatedUserId(((TSysUser)session.getAttribute(Constants.USER_SESSION)).getId());
//            if (service.insert(user)>0){
//                return "redirecet:/user/list";
//            }
//        }
//        return "sysUser/add";
//    }
//    更新
    @GetMapping("/toUpdate")
    public String toUpdate(String id, Model model) {
        logger.info("单查询用户id = "+id);
        model.addAttribute("user", service.queryById(Long.valueOf(id)));
        return "sysUser/update";
    }
    @PostMapping("/update")
    public String update(TSysUser user, HttpSession session) {
        logger.info("单修改用户信息");
        user.setCreatedUserId(((TSysUser)session.getAttribute(Constants.USER_SESSION)).getId());
        if (service.update(user) > 0) {
            return "redirect:/user/list";
        }
        return "sysUser/add";
    }


}
