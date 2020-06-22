package com.xtu.hrms.mapper;

import com.xtu.hrms.bean.Emptrain;

import java.util.List;

public interface EmptrainMapper {
    Emptrain getEmptrainById(Integer id);

    //    查询所有
    List<Emptrain> getAllEmptrains();

    List<Emptrain> getEmptrainAndEmp();

    //    根据id删除
    int deleteEmptrainById(Integer id);

    //    添加
    int addEmptrain(Emptrain emptrain);

    //    更新
    int updateEmptrain(Emptrain emptrain);

    List<Emptrain> query(String name);
}
