package com.shubham.Controller;


import com.shubham.Entity.Student;
import com.shubham.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {
    @Autowired
    private StudentRepository repository;

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(repository.save(student), HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<Student> UpdateStudentDetails(@RequestBody Student student, @PathVariable Long id) {
        Student student1 = repository.findById(id).get();
        student1.setName(student.getName());
        student1.setPassword(student.getPassword());
        student1.setFeesPaid(student.getFeesPaid());
        repository.save(student1);

        return new ResponseEntity<>(student1, HttpStatus.OK);
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {

        if(repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>("Record Deleted with id : "+id, HttpStatus.OK);
        } else  {
            return new ResponseEntity<>("No Record Found with id : "+id, HttpStatus.NOT_FOUND);
        }
    }
}

