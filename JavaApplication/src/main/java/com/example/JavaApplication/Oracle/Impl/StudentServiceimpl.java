package com.example.JavaApplication.Oracle.Impl;

import com.example.JavaApplication.Oracle.Entity.Student;
import com.example.JavaApplication.Oracle.Repository.OracleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("oracleStudentService")
public class StudentServiceimpl  {
    @Autowired
    OracleRepository oracleRepository;
    @Transactional
    public String saveStudentDetils(Student student) {
        oracleRepository.save(student);
        return "Sucsess";
    }
}
