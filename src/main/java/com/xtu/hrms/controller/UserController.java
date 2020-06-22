package com.xtu.hrms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xtu.hrms.bean.User;
import com.xtu.hrms.config.PaginationConstant;
import com.xtu.hrms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    // 查询所有
    @GetMapping("/users")
    public String list(Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {
        if(ObjectUtils.isEmpty(pageNum)){
            pageNum= PaginationConstant.CURRENT_NUM;
        }
        //设置分页(当前页，和每页显示数据条数)
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        //查找数据
        List<User> users = userService.getAllUsers();
        //将查找出的结果封装到PageInfo对象中，这个对象包含了 emps集合和关于分页的方法，如下
        //pageInfo.getPageNum();
        //pageInfo.getPages(); 得到总页数
        //pageInfo.getNextPage(); 得到下一页
        //pageInfo.getPrePage(); 得到前一页
        PageInfo<User> pageInfo=new PageInfo<>(users);
        //用Model传递对象到page页面
        model.addAttribute("pageInfo",pageInfo);
        return "user/user";
    }

    // 来到添加页面
    @GetMapping("/user")
    public String toAddPage(Model model) {
        // 来到添加页面

        return "user/add";
    }

    // 合同添加
    // SpringMVC 自动将请求参数和入参对象的属性进行一一绑定，要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/user")
    public String addUser(User user) {
        // 保存
        userService.addUser(user);
        // 来到列表页面
        // redirect: 表示重定向到一个地址 /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/users";
    }

    // 来到修改页面
    @GetMapping("/user/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user",user);

        // 回到修改页面（add是一个修改添加二合一的页面）
        return "user/add";
    }

    // 修改，需要提交id
    @PutMapping("/user")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    //删除
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id") Integer id){
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
