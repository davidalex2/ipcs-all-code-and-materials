package com.ipcs.forminio.service;

import com.ipcs.forminio.dto.BankDto;
import com.ipcs.forminio.impl.BankImpl;
import com.ipcs.forminio.model.BankEntity;
import com.ipcs.forminio.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankService implements BankImpl {
    @Autowired
    private BankRepo bankRepo;

 public BankEntity createBankEntity(BankDto bankDto){
    return bankRepo.save(BankEntity.toEntity(bankDto));
 }
 public BankEntity updateBankEntity(long id, BankDto bankDto) {
     BankEntity bankEntity = new BankEntity();
     Optional<BankEntity> studentOptional = Optional.of(bankRepo.findById(id).get());
     if (studentOptional.isPresent()) {
         bankEntity.setA_id(id);
         bankEntity.setName(bankDto.getName());
         bankEntity.setMobile(bankDto.getMobile());
         bankEntity.setBalance(bankDto.getBalance());
         bankEntity.setAddress(bankDto.getAddress());
         bankRepo.save(bankEntity);
     }
     return bankEntity;
 }
 public BankEntity getBankEntity(long id) {
     BankEntity bankEntity= bankRepo.findById(id).orElse(null);
     return bankEntity;
 }
 public void deleteBankEntity(long id) {
     BankEntity bank = bankRepo.findById(id).orElse(null);
     bankRepo.deleteById(bank.getA_id());
 }
 public List<BankEntity> getAllBankEntities() {
     List<BankEntity> bankEntity = new ArrayList<>();
     bankRepo.findAll().forEach(bankEntity::add);
     return BankEntity.toList(bankEntity);
 }
 public List<BankEntity> getLessBalance(int amount) {
     List<BankEntity> bankEntity = new ArrayList<>();
     bankRepo.findAll().forEach(entity -> {
         if (entity.getBalance() < amount) {
             bankEntity.add(entity);
         }
     });
     return BankEntity.toList(bankEntity);
 }
 public BankEntity deposit(long it, double amount) {
     BankEntity bankEntity = bankRepo.findById(it).orElse(null);
     if (bankEntity!= null) {
         bankEntity.setBalance(bankEntity.getBalance() + amount);
         bankRepo.save(bankEntity);
     }
     return bankEntity;
 }
 public BankEntity withdraw(long id, double amount) {
     BankEntity bankEntity = bankRepo.findById(id).orElse(null);
     if (bankEntity!= null && bankEntity.getBalance() >= amount) {
         bankEntity.setBalance(bankEntity.getBalance() - amount);
         bankRepo.save(bankEntity);
     }
     return bankEntity;
 }

}
