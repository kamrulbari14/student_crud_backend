package com.dev.student_crud.controller;

import com.dev.student_crud.entity.Student;
import com.dev.student_crud.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/getbyId/{id}")
    public Student getById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PatchMapping("/updateStudent/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
        student.setId(id);
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
