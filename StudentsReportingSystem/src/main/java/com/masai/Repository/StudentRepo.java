package com.masai.Repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Student;

//public interface StudentRepo extends JpaRepository<Student,Integer>{
//
//}


public interface StudentRepo extends ElasticsearchRepository<Student, Integer> {

	List<Student> findSemester(Integer semester);

}
