package com.xtu.hrms.mapper;

import com.xtu.hrms.bean.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

// 指定这是一个操作数据库的Mapper
@Mapper
@Repository
public interface DeptMapper {
//    根据id查询部门
//    @Select("select * from dept where id=#{id}")
    Dept getDeptById(Integer id);

//    查询所有部门
    List<Dept> getAllDepts();

//    根据id删除部门
    int deleteDeptById(Integer id);

//    添加部门
    int addDept(Dept dept);

//    更新部门
//    @Update("update dept set name=#{name} where id=#{id}")
    int updateDept(Dept dept);
}
