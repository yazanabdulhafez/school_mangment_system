package com.yazan.schoolMangment.Controllers;

import com.yazan.schoolMangment.Models.Parent;
import com.yazan.schoolMangment.Models.Student;
import com.yazan.schoolMangment.Repositories.StudentRepository;
import com.yazan.schoolMangment.Services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class StudentController {

    private static final Logger logger=Logger.getLogger(Student.class.getName());

    @Autowired
    private StudentsService studentsService;





//    @DeleteMapping("/deleteStudent")
//    public void deleteStudent(@RequestParam Integer id) {
//        studentService.deleteStudent(id);
//    }
//
//    @PutMapping("/updateStudents")
//    public Student updateStudent(@RequestBody Student student) {
//        return  studentService.updateStudent(student);
//    }

    @GetMapping("/Students")
    public String getStudends(Model model){
     List<Student> students= (List<Student>) studentsService.getStudents();
     model.addAttribute("students",students);
     return "students";
    }

    @GetMapping("/getStudent/{id}")
    public String getStudend(Model model,@PathVariable Long id){
        Optional<Student> student=  studentsService.getStudent(id);
        model.addAttribute("student",student);
        return "student";
    }

    @GetMapping("/removeAllStu")
    public String removeAllStudents(){
        studentsService.deleteAllStudents();
        return "students";
    }


    @GetMapping("/addStu")
    public String addStudents(){
        Parent parent=new Parent();
        Student s1=new Student("Ahmad12","jordan","Ahmad hm yazan ali","fso361435@gmail.com","fourth",9,"amman");
        studentsService.addStudent(s1);
        return "index";
    }

//    @RequestMapping(value = "/addStudent", method = {RequestMethod.GET, RequestMethod.POST})
//    public RedirectView addNewStudent(@RequestParam String username,
//                                      @RequestParam String password,
//                                      @RequestParam String fullName,
//                                      @RequestParam String email,
//                                      @RequestParam String grade,
//                                      @RequestParam int age,
//                                      @RequestParam String address
//    ){
//
//        Student student=new Student(username,password,fullName,email,grade,age,address);
//        List<Student> students= (List<Student>) studentRepository.findAll();
//        try {
//            if (!students.contains(student)) {
//                studentRepository.save(student);
//
//            }
//            return new RedirectView("/students");
//        }catch (Exception e){
//            logger.info("The Student is already added to the database");
//            return new RedirectView("/error");
//        }
//    }

    @GetMapping("/addStudent")
    public String studentForm(Model model) {

        model.addAttribute("students",new Student());
        return "addNewStudent";
    }

    @PostMapping("/addStudent")
    public String addStudentsForm(@ModelAttribute Student student, Model model) {
        try {
            studentsService.addStudent(student);
            model.addAttribute("students", student);
            return "students";
        } catch (Exception exception){
            logger.info(exception.getMessage());
            return "error";
        }
    }

//    @RequestMapping(value="/deleteStudent/{id}", method = RequestMethod.DELETE)
//    @DeleteMapping("/deleteStudent/{id}")
    @RequestMapping("/deleteStudent/{id}")
    public RedirectView deleteStudent(@PathVariable("id") Long id){
        try {
           studentsService.deleteStudent(id);
            return  new RedirectView("/students");
        }catch(Exception exception){
            return new RedirectView( "/error");
        }
    }

    @PutMapping("/updateStudent/{id}")
    public void updateStudent(@PathVariable Long id){

    }

}
