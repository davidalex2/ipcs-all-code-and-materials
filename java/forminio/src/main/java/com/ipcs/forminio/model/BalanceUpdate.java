package com.ipcs.forminio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bal_update")
@Entity
@Embeddable
public class BalanceUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double debited;
    private double credited;
    private double newBalance;
//    @ManyToMany
//    @JoinTable(name = "bank_details",joinColumns = @JoinColumn(name = "a_id"),inverseJoinColumns = @JoinColumn(name = "id"))
//    private Set<BankEntity> roles = new HashSet<>();

}
