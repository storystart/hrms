package com.xtu.hrms.mapper;

import com.xtu.hrms.bean.Contract;

import java.util.List;

public interface ContractMapper {
    //    根据id查询合同
    Contract getContractById(Integer id);

    //   查询所有合同和员工
    List<Contract> getContractAndEmp();

    //    查询所有合同
    List<Contract> getAllContracts();

    //    根据id删除合同
    int deleteContractById(Integer id);

    //    添加合同
    int addContract(Contract contract);

    //    修改合同信息
    int updateContract(Contract contract);

    List<Contract> query(String name);
}
