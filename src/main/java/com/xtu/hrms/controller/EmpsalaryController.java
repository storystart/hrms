package com.xtu.hrms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xtu.hrms.bean.*;
import com.xtu.hrms.config.PaginationConstant;
import com.xtu.hrms.service.IEmpService;
import com.xtu.hrms.service.IEmpsalaryService;
import com.xtu.hrms.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpsalaryController {
    @Autowired
    IEmpsalaryService empsalaryService;

    @Autowired
    IEmpService empService;

    @Autowired
    ISalaryService salaryService;

    // 查询所有
    @GetMapping("/salarys")
    public String list(Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {

        if(ObjectUtils.isEmpty(pageNum)){
            pageNum= PaginationConstant.CURRENT_NUM;
        }
        //设置分页(当前页，和每页显示数据条数)
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        //查找数据
        List<Empsalary> empsalarys = empsalaryService.getAll();

        PageInfo<Empsalary> pageInfo=new PageInfo<>(empsalarys);

        //用Model传递对象到page页面
        model.addAttribute("pageInfo",pageInfo);
        return "salary/salary";
    }

    // 来到添加页面
    @GetMapping("/salary")
    public String toAddPage(Model model) {
        // 来到添加页面
        List<Emp> emps = empService.getAllEmps();
        model.addAttribute("emps",emps);

        List<Salary> salarys = salaryService.getAllSalarys();
        model.addAttribute("salarys",salarys);

        return "salary/add";
    }

    // 添加
    @PostMapping("/salary")
    public String addEmpSalary(Empsalary empsalary) {
        // 保存员工
        empsalaryService.addEmpsalary(empsalary);
        // 来到列表页面
        // redirect: 表示重定向到一个地址 /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/salarys";
    }

    // 来到修改页面
    @GetMapping("/salary/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Empsalary empsalary = empsalaryService.getEmpsalaryById(id);
        model.addAttribute("empsalary",empsalary);

        List<Emp> emps = empService.getAllEmps();
        model.addAttribute("emps",emps);

        List<Salary> salarys = salaryService.getAllSalarys();
        model.addAttribute("salarys",salarys);

        // 回到修改页面（add是一个修改添加二合一的页面）
        return "salary/add";
    }

    // 修改，需要提交id
    @PutMapping("/salary")
    public String updateEmpsalary(Empsalary empsalary) {
        empsalaryService.updateEmpsalary(empsalary);
        return "redirect:/salarys";
    }

    //删除
    @DeleteMapping("/salary/{id}")
    public String deleteEmpsalaryById(@PathVariable("id") Integer id){
        empsalaryService.deleteEmpsalaryById(id);
        return "redirect:/salarys";
    }

    @GetMapping("/salaryaccount/{id}")
    public String showSalaryAccount(@PathVariable("id") Integer id, Model model) {
        Salary salary = salaryService.getSalaryById(id);
        model.addAttribute("salary",salary);

        return "salary/salaryaccount";
    }

    @PostMapping("/salsearch")//提交表单+传回前端的映射
    public String queryEmpsalary(@RequestParam String name, Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        //查找数据
        List<Empsalary> empsalarys = empsalaryService.query(name);

        PageInfo<Empsalary> pageInfo=new PageInfo<>(empsalarys);

        model.addAttribute("pageInfo",pageInfo);
        return "salary/salary";
    }
}
