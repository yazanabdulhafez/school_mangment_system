package com.yazan.schoolMangment.Controllers;

import com.yazan.schoolMangment.Models.Parent;
import com.yazan.schoolMangment.Models.Student;
import com.yazan.schoolMangment.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class StudentController {

    private static final Logger logger=Logger.getLogger(Student.class.getName());

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/getStudents")
    public String getStudends(Model model){
     List<Student> students= (List<Student>) studentRepository.findAll();
     model.addAttribute("students",students);
     return "students";
    }

    @GetMapping("/getStudent/{id}")
    public String getStudend(Model model,@PathVariable Long id){
        Optional<Student> student=  studentRepository.findById(id);
        model.addAttribute("student",student);
        return "student";
    }

    @GetMapping("/removeAllStu")
    public String removeAllStudents(){
        studentRepository.deleteAll();
        return "students";
    }


    @GetMapping("/addStu")
    public String addStudents(){
        Parent parent=new Parent();
        Student s1=new Student("Ahmad hm yazan ali","fso361435@gmail.com","fourth",9,"amman",parent);

        studentRepository.save(s1);
        return "index";
    }

    @PostMapping("/addStudent")
    public void addNewStudent(@PathVariable String fullName,
                              @PathVariable String email,
                              @PathVariable String grade,
                              @PathVariable int age,
                              @PathVariable String address,
                              @PathVariable Parent parent
    ){

        Student student=new Student(fullName,email,grade,age,address,parent);
        List<Student> students= (List<Student>) studentRepository.findAll();
        try {
            if (!students.contains(student)) {
                studentRepository.save(student);
            } else {
               throw new IllegalArgumentException();
            }
        }catch (Exception e){
            logger.info("The Student is already added to the database");
        }
    }

    @DeleteMapping("/deleteStudent")
    public void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);

    }

    @PutMapping("/updateStudent")
    public void updateStudent(@PathVariable Long id){

    }

}
