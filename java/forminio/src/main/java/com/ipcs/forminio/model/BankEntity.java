package com.ipcs.forminio.model;

import com.ipcs.forminio.dto.BankDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_accounts")
@Entity
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long a_id;
    private String name;
    private double balance;
    private String address;
    private long mobile;



    public static BankEntity toEntity(BankDto bankDto) {
        BankEntity  entity = new BankEntity();
        entity.setName(bankDto.getName());
        entity.setBalance(bankDto.getBalance());
        entity.setAddress(bankDto.getAddress());
        entity.setMobile(bankDto.getMobile());
        return entity;
    }
    public static List<BankEntity> toList(List<BankEntity> entities) {
        BankEntity entity=new BankEntity();
        entity.getA_id();
        entity.getName();
        entity.getBalance();
        entity.getAddress();
        entity.getMobile();
        entities.add(entity);
        return entities;
    }
}
