package com.xtu.hrms.service;

import com.xtu.hrms.bean.Appraise;

import java.util.List;

public interface IAppraiseService {
    Appraise getAppraiseById(Integer id);

    List<Appraise> getAllAppraises();

    List<Appraise> getAll();

    int deleteAppraiseById(Integer id);

    int addAppraise(Appraise appraise);

    int updateAppraise(Appraise appraise);

    List<Appraise> query(String name);
}
