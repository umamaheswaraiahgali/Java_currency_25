package com.example.JavaApplication.Oracle.Controller;

import com.example.JavaApplication.Oracle.Entity.Employee;
import com.example.JavaApplication.Oracle.Entity.Student;
import com.example.JavaApplication.Oracle.Impl.StudentServiceimpl;
import com.example.JavaApplication.Oracle.Repository.OracleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Oracle")
public class OracleController {
    @GetMapping("Hello")
    public String getName(){
        return "Hello World";

    }
    @Autowired()
    @Qualifier("oracleStudentService")
    StudentServiceimpl studentServiceimpl;
    @Autowired
    OracleRepository oracleRepository;
    @GetMapping("/employee")
    public List<Employee> getEmployeeDetails(){
        List<Employee> employees= new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmployeeName("Pavan");
        employee.setEmployeeId(101);
        employee.setEmployeeAdress("Hyderabad");
        employees.add(employee);
        return employees;

    }
    @GetMapping("/getStudent")
    public Optional<Student> getStudentDetails(@RequestParam int rollnum){
       Optional<Student> student= oracleRepository.findById(String.valueOf(rollnum));
        return student;

    }
    @PostMapping("/insert")
    public String insertStudent(@RequestBody Student student){
        Student saved = new Student();
        saved.setRollnum(student.getRollnum());
        saved.setStudentFirstName(student.getStudentFirstName());
        saved.setStudentLastName(student.getStudentLastName());
        saved.setStudentAddress(student.getStudentAddress());
        saved.setStudentCity(student.getStudentCity());
        oracleRepository.save(saved);
        return "inserted Student data";
    }
}
