package com.algoriant.sms.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "student")
public class Student {

    @Id
    private int id;
    private String name;
    private int number;
public Student(Student student) {}
}
