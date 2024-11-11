package com.example.fp_system.controller;

import com.example.fp_system.model.AttendanceRecord;
import com.example.fp_system.repo.AttendanceRepository;
import com.example.fp_system.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;


    @GetMapping("/fetch")
    public ResponseEntity<List<AttendanceRecord>> fetchAttendanceData() {
        return new ResponseEntity<>(attendanceService.getAttendance(), HttpStatus.OK);

    }

}
