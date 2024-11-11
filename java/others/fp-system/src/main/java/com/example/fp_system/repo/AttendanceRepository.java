package com.example.fp_system.repo;

import com.example.fp_system.model.AttendanceRecord;
import com.example.fp_system.model.AttendanceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public abstract class AttendanceRepository implements CrudRepository<AttendanceRecord,Integer> {
    @Autowired

    private RestTemplate restTemplate;


    @SneakyThrows
    @Override
    public List<AttendanceRecord> findAll() {

        String url = "http:/192.168.29.157:8000/api/attendance"; // Replace with the actual URL

        String username = "admin";

        String password = "admin";


        // Set the authentication headers

        HttpHeaders headers = new HttpHeaders();

        headers.setBasicAuth(username, password);


        // Make the HTTP request

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);


        // Parse the response to extract the attendance data

        List<AttendanceRecord> attendanceRecords = parseResponse(response.getBody());

        return attendanceRecords;

    }


    private List<AttendanceRecord> parseResponse(String response) throws JsonProcessingException {

        // Implement the logic to parse the response and extract the attendance data

        // For example, you can use a JSON parser like Jackson to parse the response

        ObjectMapper mapper = new ObjectMapper();

        AttendanceResponse attendanceResponse = mapper.readValue(response, AttendanceResponse.class);

        return attendanceResponse.getAttendanceRecords();

    }

}


