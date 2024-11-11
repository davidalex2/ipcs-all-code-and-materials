package com.example.fp_system.model;

import java.util.List;

public class AttendanceResponse {
    private List<AttendanceRecord> attendanceRecords;
    public List<AttendanceRecord> getAttendanceRecords() {

        return attendanceRecords;

    }


    public void setAttendanceRecords(List<AttendanceRecord> attendanceRecords) {

        this.attendanceRecords = attendanceRecords;

    }
}
