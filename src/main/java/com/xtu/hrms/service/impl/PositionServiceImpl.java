package com.xtu.hrms.service.impl;

import com.xtu.hrms.bean.Position;
import com.xtu.hrms.mapper.PositionMapper;
import com.xtu.hrms.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private PositionMapper positionMapper;

    @Override
    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }
}
