package com.ipcs.example2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDto {
    private String name;
    private double balance;
    private String address;
    private long mobile;


}
