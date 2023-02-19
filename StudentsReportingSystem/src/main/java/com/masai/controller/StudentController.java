package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.Repository.StudentRepo;
import com.masai.model.Student;

@Controller
public class StudentController {

	
	@Autowired
	private StudentRepo sRepo;
	
	
	//add student-->>
	
	@PostMapping("/addStudent")
	public String saveStudent(@RequestParam Integer rollNo, @RequestParam String name,		@RequestParam Integer semester,
			@RequestParam Integer mathematics, @RequestParam Integer science, @RequestParam Integer english) {
		
		
		Student student = new Student(rollNo, name, semester, mathematics, science, english);
		sRepo.save(student);
		
		return "add";

	}

    
	//percent-->>
    @PostMapping("/getAllPercentage")
    public String getPercent(Model model, @RequestParam Integer sem) {
        	
    		
      List<Student> list = sRepo.findSemester(sem);
    		
       int total = 0;
       int count = 0;
    		
       for (Student s1 : list) {
    			
    		total += s1.getMathematics() + s1.getScience() + s1.getEnglish();
    			
    		count++;
    			
    	}
    		
    		
    	total = total / count;
    		
    	total = total * 100 / 300;
    		
    		
    	model.addAttribute("per", total);
    	return "percent";
    		
    	}
        
        //avg-->>
    
        @PostMapping("/avgAllMarks")
    	public String avgMarks(Model model, @RequestParam String sub) {
        	
            List<Student> list = new ArrayList<>();
    		Iterable<Student> itr = sRepo.findAll();
        
            
            int count = 0;
    		int total = 0;
    		
    		itr.forEach(list::add);
    		for (Student s1 : list) {
    			
    		
    		if (sub.equalsIgnoreCase("mathematics")) {
    			total  += s1.getMathematics();
    		} 
    		else if (sub.equalsIgnoreCase("science")) {
    			total  += s1.getScience();
    		}
    		else if (sub.equalsIgnoreCase("english")) {
    			total  +=s1.getEnglish();
    		} 
    		count++;
    		
    		}
    		model.addAttribute("avg", total / count);
    		
    		return "avg";
    	}
        
    	//get report-->>
    	@GetMapping("/add")
    	public String add() {
    		return "add";

    	}
    	//get add-->>
    	@GetMapping("/addStudent")
    	public String addStudent() {
    		return "AddStudent";

    	}
    	//get percent-->>
    	@GetMapping("/getPercentage")
    	public String getPercentAgeView() {
    		return "resultPercentage";
    	}

    	//get avg-->>
    	@GetMapping("/avgMarks")
    	public String avgMarks() {

    		return "ResultAvg";
    	}
	
}
