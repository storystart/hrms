package com.xtu.hrms.mapper;

import com.xtu.hrms.bean.Emprp;

import java.util.List;

public interface EmprpMapper {
    Emprp getEmprpById(Integer id);

    //    查询所有
    List<Emprp> getAllEmprps();

    List<Emprp> getEmprpAndEmp();

    //    根据id删除
    int deleteEmprpById(Integer id);

    //    添加
    int addEmprp(Emprp emprp);

    //    更新
    int updateEmprp(Emprp emprp);

    List<Emprp> query(String name);
}
