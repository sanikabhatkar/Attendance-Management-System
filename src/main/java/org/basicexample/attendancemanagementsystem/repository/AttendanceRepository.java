package org.basicexample.attendancemanagementsystem.repository;

import org.basicexample.attendancemanagementsystem.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    List<Attendance> findByDate (LocalDate date);
}
