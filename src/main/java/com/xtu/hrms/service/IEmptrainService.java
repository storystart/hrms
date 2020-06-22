package com.xtu.hrms.service;

import com.xtu.hrms.bean.Emptrain;

import java.util.List;

public interface IEmptrainService {
    Emptrain getEmptrainById(Integer id);

    List<Emptrain> getAllEmptrains();

    List<Emptrain> getEmptrainAndEmp();

    int deleteEmptrainById(Integer id);

    int addEmptrain(Emptrain emptrain);

    int updateEmptrain(Emptrain emptrain);

    List<Emptrain> query(String name);
}
