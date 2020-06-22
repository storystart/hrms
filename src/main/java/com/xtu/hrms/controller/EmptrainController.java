package com.xtu.hrms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xtu.hrms.bean.Emp;
import com.xtu.hrms.bean.Emprp;
import com.xtu.hrms.bean.Emptrain;
import com.xtu.hrms.config.PaginationConstant;
import com.xtu.hrms.service.IEmpService;
import com.xtu.hrms.service.IEmptrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmptrainController {
    @Autowired
    IEmptrainService emptrainService;

    @Autowired
    IEmpService empService;
    // 查询所有
    @GetMapping("/trains")
    public String list(Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {

        if(ObjectUtils.isEmpty(pageNum)){
            pageNum= PaginationConstant.CURRENT_NUM;
        }
        //设置分页(当前页，和每页显示数据条数)
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        //查找数据
        List<Emptrain> emptrains = emptrainService.getEmptrainAndEmp();

        PageInfo<Emptrain> pageInfo=new PageInfo<>(emptrains);

        //用Model传递对象到page页面
        model.addAttribute("pageInfo",pageInfo);
        return "train/train";
    }

    // 来到添加页面
    @GetMapping("/train")
    public String toAddPage(Model model) {
        // 来到添加页面
        List<Emp> emps = empService.getAllEmps();
        model.addAttribute("emps",emps);

        return "train/add";
    }

    // 添加
    @PostMapping("/train")
    public String addEmptrain(Emptrain emptrain) {
        // 保存员工
        emptrainService.addEmptrain(emptrain);
        // 来到列表页面
        // redirect: 表示重定向到一个地址 /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/trains";
    }

    // 来到修改页面
    @GetMapping("/train/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Emptrain emptrain = emptrainService.getEmptrainById(id);
        model.addAttribute("train",emptrain);

        List<Emp> emps = empService.getAllEmps();
        model.addAttribute("emps",emps);

        // 回到修改页面（add是一个修改添加二合一的页面）
        return "train/add";
    }

    // 修改，需要提交id
    @PutMapping("/train")
    public String updateEmptrain(Emptrain emptrain) {
        emptrainService.updateEmptrain(emptrain);
        return "redirect:/trains";
    }

    //删除
    @DeleteMapping("/train/{id}")
    public String deleteEmptrainById(@PathVariable("id") Integer id){
        emptrainService.deleteEmptrainById(id);
        return "redirect:/trains";
    }

    @PostMapping("/trasearch")//提交表单+传回前端的映射
    public String queryEmptrain(@RequestParam String name, Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        //查找数据
        List<Emptrain> emptrains = emptrainService.query(name);

        PageInfo<Emptrain> pageInfo=new PageInfo<>(emptrains);

        model.addAttribute("pageInfo",pageInfo);
        return "train/train";
    }
}
