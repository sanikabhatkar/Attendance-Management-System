package org.basicexample.attendancemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttendanceManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttendanceManagementSystemApplication.class, args);
    }

}

/*
    Functionalities of this Attendance Management System
    - Mark Attendance
    - View Attendance by Date
    - Update Attendance
    - Fetch Attendance Records
 */

/*
     Validation Error:
     - Used when the client/user sends invalid or incomplete input.
     - Example: Name is empty, Status is missing.
     - Returns: 400 Bad Request

     Custom Exception:
     - Used when the request is valid, but the application cannot complete it.
     - Example: Attendance ID not found.
     - Usually returns: 404 Not Found
*/