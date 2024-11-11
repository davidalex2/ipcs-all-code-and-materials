package com.ipcs.forminio.repository;

import com.ipcs.forminio.model.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<BankEntity,Long>{
}
