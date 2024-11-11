package com.ipcs.example2.repository;

import com.ipcs.example2.model.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<BankEntity,Long>{
}
