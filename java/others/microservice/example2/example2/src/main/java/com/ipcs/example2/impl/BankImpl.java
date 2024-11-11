package com.ipcs.example2.impl;

import com.ipcs.example2.dto.BankDto;
import com.ipcs.example2.model.BankEntity;

import java.util.List;


public interface BankImpl {
//    public BankEntity createUser(BankDto bankDto);
    public BankEntity updateBankEntity(long id, BankDto bankDto);
    public BankEntity createBankEntity(BankDto bankDto);
    public BankEntity getBankEntity(long id);
    public void deleteBankEntity(long id);
    public List<BankEntity> getAllBankEntities();
    public List<BankEntity> getLessBalance(int amount);
}
