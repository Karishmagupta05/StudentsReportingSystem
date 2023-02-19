package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Entity
@Document(indexName="student")
public class Student {



	@Id
	private Integer RollNo;
	
	private String Name;
	
	private Integer Semester ;
	
	private Integer mathematics;
	
	private Integer science;
	
	private Integer english;

	public Student(Integer rollNo, String name, Integer semester, Integer mathematics, Integer science,
			Integer english) {
		super();
		RollNo = rollNo;
		Name = name;
		this.Semester = semester;
		this.mathematics = mathematics;
		this.science = science;
		this.english = english;
	}


	
//	private Marks marks;
	
	
	
}


