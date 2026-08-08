package org.basicexample.attendancemanagementsystem.exception;

import org.basicexample.attendancemanagementsystem.entity.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AttendanceExceptionHandler {

    @ExceptionHandler(AttendanceNotFoundException.class)
    ResponseEntity<ResponseStructure<String>> handleANFE (AttendanceNotFoundException attendanceNotFoundException){
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setMessage(attendanceNotFoundException.getMessage());
        structure.setData("Attendance Record Not Found");
        structure.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
    }
}
