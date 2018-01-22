package com.stu.web;

import com.stu.entity.User;
import com.stu.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by qixuan on 2017/12/6.
 * 处理学生相关请求的Controller类
 */

@Controller
@RequestMapping("/userController")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping("/userLogin")
    @ResponseBody
    public String userLogin(User user, HttpSession session){
        user = userService.userLogin(user);
        if(user != null){
            session.setAttribute("login_user", user);
            return "loginSuccess";
        }
        return "loginFail";
    }

    @RequestMapping("/exitLogin")
    public String exitLogin(HttpSession session){
        session.setAttribute("login_user",null);
        return "redirect:/index.jsp";
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
