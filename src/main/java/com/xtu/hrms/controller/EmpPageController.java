package com.xtu.hrms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xtu.hrms.bean.Emp;
import com.xtu.hrms.config.PaginationConstant;
import com.xtu.hrms.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmpPageController {
    @Autowired
    private IEmpService empService;

    @GetMapping("/page")
    public String findAll(Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {
        if(ObjectUtils.isEmpty(pageNum)){
            pageNum=PaginationConstant.CURRENT_NUM;
        }
        //设置分页(当前页，和每页显示数据条数)
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        //查找数据
        List<Emp> emps = empService.getEmpAndDept();
        //将查找出的结果封装到PageInfo对象中，这个对象包含了 emps集合和关于分页的方法，如下
        //pageInfo.getPageNum();
        //pageInfo.getPages(); 得到总页数
        //pageInfo.getNextPage(); 得到下一页
        //pageInfo.getPrePage(); 得到前一页
        PageInfo<Emp> pageInfo=new PageInfo<>(emps);
        // model.addAttribute("emps",emps);
        //用Model传递对象到page页面
        model.addAttribute("pageInfo",pageInfo);
        return "emp/page";
    }
}
