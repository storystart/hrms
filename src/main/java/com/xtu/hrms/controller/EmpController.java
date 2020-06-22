package com.xtu.hrms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xtu.hrms.bean.Dept;
import com.xtu.hrms.bean.Emp;
import com.xtu.hrms.bean.Nation;
import com.xtu.hrms.bean.Position;
import com.xtu.hrms.config.PaginationConstant;
import com.xtu.hrms.service.IDeptService;
import com.xtu.hrms.service.IEmpService;
import com.xtu.hrms.service.INationService;
import com.xtu.hrms.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    IEmpService empService;

    @Autowired
    IDeptService deptService;

    @Autowired
    INationService nationService;

    @Autowired
    IPositionService positionService;

    // 查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum) {
//        List<Emp> emps = empService.getAllEmps();
//        List<Emp> emps = empService.getEmpAndDept();

        // 放在请求域中
//        model.addAttribute("emps",emps);
        // thymleaf默认就会拼串
        // classpath:/templates/xxx.html
        if(ObjectUtils.isEmpty(pageNum)){
            pageNum= PaginationConstant.CURRENT_NUM;
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
        return "emp/list";
    }

    // 来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 来到添加页面，查出所有的部门，在页面显示
        List<Dept> depts = deptService.getAllDepts();
        model.addAttribute("depts",depts);
        // 查出所有民族
        List<Nation> nations = nationService.getAllNations();
        model.addAttribute("nations",nations);
        // 查出所有职位
        List<Position> positions = positionService.getAllPositions();
        model.addAttribute("positions",positions);
        return "emp/add";
    }

    // 员工添加
    // SpringMVC 自动将请求参数和入参对象的属性进行一一绑定，要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Emp emp) {
//        System.out.println("保存的员工信息"+emp);
        // 保存员工
        empService.addEmp(emp);
        // 来到员工列表页面
        // redirect: 表示重定向到一个地址 /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    // 来到修改页面，查出当前员工，在页面显示
    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id,Model model) {
        Emp emp = empService.getEmpById(id);
        model.addAttribute("emp",emp);

        // 页面要显示所有的部门列表
        List<Dept> depts = deptService.getAllDepts();
        model.addAttribute("depts",depts);
        // 查出所有民族
        List<Nation> nations = nationService.getAllNations();
        model.addAttribute("nations",nations);
        // 查出所有职位
        List<Position> positions = positionService.getAllPositions();
        model.addAttribute("positions",positions);
        // 回到修改页面（add是一个修改添加二合一的页面）
        return "emp/add";
    }

    // 员工修改，需要提交员工id
    @PutMapping("/emp")
    public String updateEmp(Emp emp) {
//        System.out.println("修改的员工数据：" + emp);
        empService.updateEmp(emp);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmpById(@PathVariable("id") Integer id){
        empService.deleteEmpById(id);
        return "redirect:/emps";
    }


    // 查询某个员工
    @PostMapping("/search")//提交表单+传回前端的映射
    public String queryEmp(@RequestParam String name, Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        //查找数据
        List<Emp> emps=empService.query(name);
        model.addAttribute("emps",emps);//传回前端
        PageInfo<Emp> pageInfo=new PageInfo<>(emps);
        // model.addAttribute("emps",emps);
        //用Model传递对象到page页面
        model.addAttribute("pageInfo",pageInfo);
        return "emp/list";
    }
}
