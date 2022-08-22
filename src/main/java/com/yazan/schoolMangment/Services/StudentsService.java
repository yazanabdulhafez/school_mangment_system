package com.yazan.schoolMangment.Services;


import com.yazan.schoolMangment.Models.Student;
import com.yazan.schoolMangment.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getStudent(Long id){
      return studentRepository.findById(id);
    }

    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


    public Student updateStudent(Student student) {
        Long studentId = student.getId();

        Student std = studentRepository.findById(studentId).get();
        std.setUsername(student.getUsername());
        std.setPassword(student.getPassword());
        std.setFullName(student.getFullName());
        std.setEmail(student.getEmail());
        std.setGrade(student.getGrade());
        std.setAge(student.getAge());
        std.setAddress(student.getAddress());
        return studentRepository.save(std);
    }

}
