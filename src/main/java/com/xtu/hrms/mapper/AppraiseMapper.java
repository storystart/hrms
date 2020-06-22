package com.xtu.hrms.mapper;

import com.xtu.hrms.bean.Appraise;

import java.util.List;

public interface AppraiseMapper {
    Appraise getAppraiseById(Integer id);

    //    查询所有
    List<Appraise> getAllAppraises();

    List<Appraise> getAll();

    //    根据id删除
    int deleteAppraiseById(Integer id);

    //    添加
    int addAppraise(Appraise appraise);

    //    更新
    int updateAppraise(Appraise appraise);

    List<Appraise> query(String name);
}
