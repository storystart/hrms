package com.xtu.hrms.controller;

import com.xtu.hrms.bean.User;
import com.xtu.hrms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    定义后台用户业务对象
    @Autowired
    private IUserService userService;

//    @RequestMapping("/")
//    public String index() {
//        return "login";
//    }

    @PostMapping(value = "/user/login")
    public String login(User user, Map<String, Object> map, HttpSession session){
//        根据用户名和密码进行登录校验
        User u = userService.login(user);

        if(u==null) {
//        登录失败
            map.put("msg","用户名密码错误！");
            return "login";

        } else {
//            登录成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",user.getUsername());
            return "redirect:/main.html";
        }

    }

    @RequestMapping(value = "/user/logout")
    public String logout(){
        return "login";
    }
}
