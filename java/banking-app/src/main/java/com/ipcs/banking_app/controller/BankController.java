package com.ipcs.banking_app.controller;

import com.ipcs.banking_app.dto.BankDto;
import com.ipcs.banking_app.model.BankEntity;
import com.ipcs.banking_app.service.BankService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Bank API", description = "Operations related to bank")
@CrossOrigin(origins = "*")
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;

    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<BankEntity>> getAllAccounts(){
        return new ResponseEntity<>(bankService.getAllBankEntities(), HttpStatus.OK);
    }
    @GetMapping("/getAccount/{id}")
    public ResponseEntity<BankEntity> getAccount(@PathVariable("id") long id){
        return new ResponseEntity<>(bankService.getBankEntity(id),HttpStatus.OK);
    }
    @PostMapping("/addAccount")
    public ResponseEntity<BankEntity> addAccount(@RequestBody BankDto bankDto){
        return new ResponseEntity<>(bankService.createBankEntity(bankDto), HttpStatus.CREATED);
    }
    @PutMapping("/updateAccount/{id}")
    public ResponseEntity<BankEntity> updateAccount(@PathVariable("id") long id, @RequestBody BankDto bankDto){
        return new ResponseEntity<>(bankService.updateBankEntity(id, bankDto), HttpStatus.OK);
    }
    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") long id){
        bankService.deleteBankEntity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/less/{amount}")
    public ResponseEntity<List<BankEntity>> less(@PathVariable("amount") int amount){
        return new ResponseEntity<>(bankService.getLessBalance(amount), HttpStatus.OK);
    }



}
