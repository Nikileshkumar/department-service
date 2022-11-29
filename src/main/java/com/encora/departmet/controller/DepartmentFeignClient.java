package com.encora.departmet.controller;

import com.encora.departmet.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "STUDENT-SERVICE")
public interface DepartmentFeignClient {

    @GetMapping("/student/studentDetail/{departmentName}")
    List<Student> getStudentDetails(@PathVariable String departmentName);

    @GetMapping("/student/{studentName}")
    Student getStudentDepartment(@PathVariable String studentName);

}
