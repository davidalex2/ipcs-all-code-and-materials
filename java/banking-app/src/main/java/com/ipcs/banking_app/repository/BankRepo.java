package com.ipcs.banking_app.repository;

import com.ipcs.banking_app.model.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<BankEntity,Long>{
}
