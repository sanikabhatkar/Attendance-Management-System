package org.basicexample.attendancemanagementsystem.exception;

public class AttendanceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AttendanceNotFoundException(String message) {
        super(message);
    }
}

/*
    private static final long serialVersionUID = 1L;

    UID : Unique Identifier
    For example : If a class is created, and then it is updated, it must be checked it they are compatible.
    1L states that it is version 1, if any changes are made then they are considered under 2L.

 */