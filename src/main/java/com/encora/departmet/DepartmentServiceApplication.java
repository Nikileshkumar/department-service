package com.encora.departmet;

import com.encora.departmet.model.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/department")
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/hello")
	public String hello(){
		return "I am department service";
	}

	@GetMapping("/studentDetails/{departmentId}")
	public StudentDetails getStudentDetails(@PathVariable("departmentId") String departmentId) {
		StudentDetails listOfStudents = restTemplate.getForObject("http://STUDENT-SERVICE/student/" + departmentId, StudentDetails.class);
		return listOfStudents;
	}

	@GetMapping("/departmentDetails/{studentName}")
	public String getDepartmentDetails(@PathVariable("studentName") String studentName) {
		if (studentName.equals("Rahul") || studentName.equals("Nikilesh")) {
			return "employees";
		} else if (studentName.equals("Thimmaiah") || studentName.equals("Kishore")) {
			return "Managers";
		}
		return "StudentName not found";
	}
}
