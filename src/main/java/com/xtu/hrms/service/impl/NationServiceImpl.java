package com.xtu.hrms.service.impl;

import com.xtu.hrms.bean.Nation;
import com.xtu.hrms.mapper.NationMapper;
import com.xtu.hrms.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements INationService {
    @Autowired
    private NationMapper nationMapper;
    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
