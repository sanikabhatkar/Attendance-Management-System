package org.basicexample.attendancemanagementsystem.controller;

import org.basicexample.attendancemanagementsystem.entity.Attendance;
import org.basicexample.attendancemanagementsystem.entity.ResponseStructure;
import org.basicexample.attendancemanagementsystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping(value = "/addAttendance")
    public ResponseEntity<ResponseStructure<Attendance>> markAttendance (@RequestBody Attendance attendance){
        return attendanceService.markAttendance(attendance);
    }

    @GetMapping(value = "/getAllAttendance")
    public ResponseEntity<ResponseStructure<List<Attendance>>> getAllAttendance(){
        return attendanceService.getAllAttendance();
    }

    @PutMapping(value = "/updateAttendance/{id}")
    public ResponseEntity<ResponseStructure<Attendance>> updateAttendance (@RequestBody Attendance attendance, @PathVariable int id){
        return attendanceService.updateAttendance(attendance, id);
    }

    @GetMapping(value = "/getAttendance/{date}")
    public ResponseEntity<ResponseStructure<List<Attendance>>> viewAttendanceByDate (@PathVariable LocalDate date) {
        return attendanceService.viewAttendanceByDate(date);
    }

    @DeleteMapping(value = "/deleteAttendance/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteAttendanceById (@PathVariable int id){
        return attendanceService.deleteAttendanceById(id);
    }

}
