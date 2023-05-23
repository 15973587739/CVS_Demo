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
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    TSysUserService service = new TSysUserServiceImpl();
    TSysRoleService roleService = new TSysRoleServiceImpl();

    public SysUserController() {
        try {
            sysUsers.add(new TSysUser(25L,"ads","阿达","67787878",1,"23421433","上海区1",2L,1L,new Date(),1L,new Date()));
            sysUsers.add(new TSysUser(45L,"adsf","阿1达","67787878",1,"23421243","上海区2",13L,1L,new Date(),1L,new Date()));
            sysUsers.add(new TSysUser(55L,"adsg","阿2达","67787878",1,"23421343","上海区3",12L,1L,new Date(),1L,new Date()));
            sysUsers.add(new TSysUser(65L,"adds","阿3达","67787878",1,"23421143","上海区4",11L,1L,new Date(),1L,new Date()));
            sysUsers.add(new TSysUser(75L,"adfs","阿4达","67787878",1,"23432143","上海区5",10L,1L,new Date(),1L,new Date()));
            sysUsers.add(new TSysUser(85L,"ades","阿5达","67787878",1,"23442143","上海区6",16L,1L,new Date(),1L,new Date()));
            sysUsers.add(new TSysUser(65L,"adgs","阿3达","67787878",1,"23425143","上海区7",15L,1L,new Date(),1L,new Date()));
        }catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

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
    @GetMapping(value ="list")
    public String list(Model model) throws Exception {
        logger.info("单查询条件为空时，查询用户信息");
        queryUsers.clear();
        queryUsers.addAll(sysUsers);
        model.addAttribute("queryUsers",queryUsers);
        return "sysUser/sysUserList";
    }
    @PostMapping("/list")
    public String list(@RequestParam(value="realName",required = false) String realName, Model model) throws Exception {
        logger.info("查询条件:realName = " + realName+",查询用户信息");
        queryUsers.clear();
        if (realName != null && realName.equals("")) {
            for (TSysUser user : queryUsers){
                if (user.getRealName().indexOf(realName)!= -1){
                    queryUsers.add(user);
                }
            }
        }else {
            queryUsers.addAll(sysUsers);
        }
        model.addAttribute("queryUsers", queryUsers);
        return "sysUser/sysUserList";
    }

    @GetMapping("/list")
    public String getUserList(Model model,String realName,Long roleId, @RequestParam(defaultValue = "1")Integer pageIndex){
        List<TSysUser> userList = null;
        try {
            int pageSize = Constants.pageSize;
            TSysUser user = new TSysUser();
            user.setRealName(realName);
            user.setRoleId(roleId);
            Long totalCount = service.count(user);

            Pager page = new Pager();
            page.setPageNo(pageIndex);
            page.setPageSize(pageSize);
            page.setPageCount(Math.toIntExact(totalCount));

            int totalPageCount = page.getRowCount();
            if (pageIndex > totalPageCount){
                pageIndex = totalPageCount;
                throw  new RuntimeException("页码不正确");
            }

            userList = service.selectPageList(realName, Math.toIntExact(roleId),pageIndex,pageSize);
            model.addAttribute("userList",userList);
            List<TSysRole> roleList = null;
            roleList = roleService.getSysRoleList("");
            model.addAttribute("roleList", roleList);
            model.addAttribute("pageIndex", pageIndex);
            model.addAttribute("totalPageCount", totalPageCount);
            model.addAttribute("totalCount", totalCount);
            model.addAttribute("realName",realName);
            model.addAttribute("roleId",roleId==null?0:roleId);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表接口访问失败");
            return "redirect:/user/toSysError";
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
