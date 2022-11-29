package com.encora.departmet.controller;

import com.encora.departmet.model.Department;
import com.encora.departmet.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentFeignClient studentService;

    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping("/{departmentName}")
    public Department getDepartmentId(@PathVariable String departmentName){
        return departmentRepo.findByDepartmentName(departmentName);
    }

    @GetMapping("/departmentDetails/{studentName}")
    public String getDepartmentDetails(@PathVariable("studentName") String studentName) {
        return departmentRepo.getReferenceById(studentService.getStudentDepartment(studentName).getDepartmentId()).getDepartmentName();
    }
}
