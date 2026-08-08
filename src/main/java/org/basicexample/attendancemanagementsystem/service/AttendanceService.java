package org.basicexample.attendancemanagementsystem.service;

import org.basicexample.attendancemanagementsystem.entity.Attendance;
import org.basicexample.attendancemanagementsystem.entity.ResponseStructure;
import org.basicexample.attendancemanagementsystem.exception.AttendanceNotFoundException;
import org.basicexample.attendancemanagementsystem.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Mark the attendance or Add the attendance
    public ResponseEntity<ResponseStructure<Attendance>> markAttendance (Attendance attendance){
        ResponseStructure<Attendance> structure = new ResponseStructure<>();
        structure.setData(attendanceRepository.save(attendance));
        structure.setMessage("Attendance has been added successfully!");
        structure.setStatus(HttpStatus.CREATED.value()); // Status : 201

        return new ResponseEntity<ResponseStructure<Attendance>>(structure, HttpStatus.CREATED);
    }

    // Fetch all attendance
    public ResponseEntity<ResponseStructure<List<Attendance>>> getAllAttendance(){
        ResponseStructure<List<Attendance>> structure = new ResponseStructure<>();

        List<Attendance> saveAttendance = attendanceRepository.findAll();

        if(!saveAttendance.isEmpty()){
            structure.setData(saveAttendance);
            structure.setMessage("Attendance Records Found Successfully!");
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<ResponseStructure<List<Attendance>>>(structure, HttpStatus.OK);
        }

        throw new AttendanceNotFoundException("Attendance Record Not Found!");
    }

    // Update the attendance by ID
    public ResponseEntity<ResponseStructure<Attendance>> updateAttendance(Attendance attendance, int id){
        ResponseStructure<Attendance> structure = new ResponseStructure<>();

        Optional<Attendance> recordAttendance = attendanceRepository.findById(id);

        if(recordAttendance.isPresent()){
            Attendance existingAttendance = recordAttendance.get();
            existingAttendance.setName(attendance.getName());
            existingAttendance.setRemarks(attendance.getRemarks());
            existingAttendance.setStatus(attendance.getStatus());
            // existingAttendance.setDate(attendance.getDate()); // unsure about date because, the updatable is false!

            structure.setMessage("The Attendance for ID: " + id + " has been updated");
            structure.setData(attendanceRepository.save(existingAttendance));
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<ResponseStructure<Attendance>>(structure, HttpStatus.OK);
        }

        throw new AttendanceNotFoundException("Attendance Record for ID: " + id + " does not exist");
    }

    // Fetch / View attendance by Date
    public ResponseEntity<ResponseStructure<List<Attendance>>> viewAttendanceByDate (LocalDate date){
        ResponseStructure<List<Attendance>> structure = new ResponseStructure<>();

        List<Attendance> existDate = attendanceRepository.findByDate(date);

        // if the date exists
        if(!existDate.isEmpty()){
            structure.setMessage("The Attendance for the date: " + date + "has been displayed successfully!");
            structure.setData(existDate);
            structure.setStatus(HttpStatus.OK.value());

            return new ResponseEntity<ResponseStructure<List<Attendance>>>(structure, HttpStatus.OK);
        }

        throw new AttendanceNotFoundException("Attendance Record for the following Date: " + date + " does not exist");
    }

    // Delete attendance by ID
    public ResponseEntity<ResponseStructure<String>> deleteAttendanceById (int id){
            ResponseStructure<String> structure = new ResponseStructure<>();

        Optional<Attendance> checkRecord = attendanceRepository.findById(id);

        if(checkRecord.isPresent()){

            attendanceRepository.deleteById(id);
            structure.setMessage("The attendance for ID :" + id + "has been deleted successfully!");
            structure.setStatus(HttpStatus.NO_CONTENT.value());
            structure.setData("The attendance record has been deleted successfully!");

            return new ResponseEntity<ResponseStructure<String>> (structure, HttpStatus.NO_CONTENT);
        }

        throw new AttendanceNotFoundException("Attendance Record for ID: " + id + " does not exist");
    }

}
