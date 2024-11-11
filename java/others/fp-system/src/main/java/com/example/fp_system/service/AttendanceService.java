package com.example.fp_system.service;

import com.example.fp_system.model.AttendanceRecord;
import com.example.fp_system.repo.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<AttendanceRecord> getAttendance(){
        return (List<AttendanceRecord>) attendanceRepository.findAll();
    }
}
