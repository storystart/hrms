package com.xtu.hrms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xtu.hrms.bean.Emp;
import com.xtu.hrms.bean.Emprp;
import com.xtu.hrms.config.PaginationConstant;
import com.xtu.hrms.service.IEmpService;
import com.xtu.hrms.service.IEmprpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmprpController {
    @Autowired
    IEmprpService emprpService;

    @Autowired
    IEmpService empService;
    // 查询所有
    @GetMapping("/emprps")
    public String list(Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum) {

        if(ObjectUtils.isEmpty(pageNum)){
            pageNum= PaginationConstant.CURRENT_NUM;
        }
        //设置分页(当前页，和每页显示数据条数)
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        //查找数据
        List<Emprp> emprps = emprpService.getEmprpAndEmp();

        PageInfo<Emprp> pageInfo=new PageInfo<>(emprps);

        //用Model传递对象到page页面
        model.addAttribute("pageInfo",pageInfo);
        return "emprp/emprp";
    }

    // 来到添加页面
    @GetMapping("/emprp")
    public String toAddPage(Model model) {
        // 来到添加页面
        List<Emp> emps = empService.getAllEmps();
        model.addAttribute("emps",emps);

        return "emprp/add";
    }

    // 添加
    @PostMapping("/emprp")
    public String addEmprp(Emprp emprp) {
        // 保存员工
        emprpService.addEmprp(emprp);
        // 来到列表页面
        // redirect: 表示重定向到一个地址 /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emprps";
    }

    // 来到修改页面
    @GetMapping("/emprp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Emprp emprp = emprpService.getEmprpById(id);
        model.addAttribute("emprp",emprp);

        List<Emp> emps = empService.getAllEmps();
        model.addAttribute("emps",emps);

        // 回到修改页面（add是一个修改添加二合一的页面）
        return "emprp/add";
    }

    // 修改，需要提交id
    @PutMapping("/emprp")
    public String updateEmprp(Emprp emprp) {
        emprpService.updateEmprp(emprp);
        return "redirect:/emprps";
    }

    //删除
    @DeleteMapping("/emprp/{id}")
    public String deleteEmprpById(@PathVariable("id") Integer id){
        emprpService.deleteEmprpById(id);
        return "redirect:/emprps";
    }

    @PostMapping("/rpsearch")//提交表单+传回前端的映射
    public String queryEmprp(@RequestParam String name, Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        //查找数据
        List<Emprp> emprps = emprpService.query(name);

        PageInfo<Emprp> pageInfo=new PageInfo<>(emprps);

        model.addAttribute("pageInfo",pageInfo);
        return "emprp/emprp";
    }
}
