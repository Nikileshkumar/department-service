package com.encora.departmet.Service;

import com.encora.departmet.model.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/department")
public class DepartmentService {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello() {
        return "I am department service";
    }

    @RequestMapping("/studentDetails/{departmentId}")
    public StudentDetails getStudentDetails(@PathVariable("departmentId") String departmentId) {
        StudentDetails listOfStudents = restTemplate.getForObject("http://STUDENT-SERVICE/student/studentDetail/" + departmentId, StudentDetails.class);
        return listOfStudents;
    }

    @RequestMapping("/departmentDetails/{studentName}")
    public String getDepartmentDetails(@PathVariable("studentName") String studentName) {
        if (studentName.equals("Rahul") || studentName.equals("Nikilesh")) {
            return "employees";
        } else if (studentName.equals("Thimmaiah") || studentName.equals("Kishore")) {
            return "Managers";
        }
        return "StudentName not found";
    }
}
