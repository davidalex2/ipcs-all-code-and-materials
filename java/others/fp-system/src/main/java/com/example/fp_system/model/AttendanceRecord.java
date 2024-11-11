package com.example.fp_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRecord {

    private String username;

    private Date date;

    private Time time;

    private boolean attendanceStatus;


    // Getters and setters

}