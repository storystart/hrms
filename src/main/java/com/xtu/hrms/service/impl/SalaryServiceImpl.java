package com.xtu.hrms.service.impl;

import com.xtu.hrms.bean.Salary;
import com.xtu.hrms.mapper.SalaryMapper;
import com.xtu.hrms.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalaryServiceImpl implements ISalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public Salary getSalaryById(Integer id) {
        return salaryMapper.getSalaryById(id);
    }

    @Override
    public List<Salary> getAllSalarys() {
        return salaryMapper.getAllSalarys();
    }

    @Override
    public int deleteSalaryById(Integer id) {
        return salaryMapper.deleteSalaryById(id);
    }

    @Override
    public int addSalary(Salary salary) {
        return salaryMapper.addSalary(salary);
    }

    @Override
    public int updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }
}
