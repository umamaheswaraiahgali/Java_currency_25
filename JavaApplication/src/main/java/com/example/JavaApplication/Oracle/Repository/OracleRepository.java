package com.example.JavaApplication.Oracle.Repository;

import com.example.JavaApplication.Oracle.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleRepository extends JpaRepository<Student, String> {
}
