package com.xtu.hrms.service.impl;

import com.xtu.hrms.bean.Empsalary;
import com.xtu.hrms.mapper.EmpsalaryMapper;
import com.xtu.hrms.service.IEmpsalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpsalaryServiceImpl implements IEmpsalaryService
{
    @Autowired
    private EmpsalaryMapper empsalaryMapper;

    @Override
    public Empsalary getEmpsalaryById(Integer id) {
        return empsalaryMapper.getEmpsalaryById(id);
    }

    @Override
    public List<Empsalary> getAllEmpsalarys() {
        return empsalaryMapper.getAllEmpsalarys();
    }

    @Override
    public List<Empsalary> getAll() {
        return empsalaryMapper.getAll();
    }

    @Override
    public int deleteEmpsalaryById(Integer id) {
        return empsalaryMapper.deleteEmpsalaryById(id);
    }

    @Override
    public int addEmpsalary(Empsalary empsalary) {
        return empsalaryMapper.addEmpsalary(empsalary);
    }

    @Override
    public int updateEmpsalary(Empsalary empsalary) {
        return empsalaryMapper.updateEmpsalary(empsalary);
    }

    @Override
    public List<Empsalary> query(String name) {
        return empsalaryMapper.query(name);
    }
}
