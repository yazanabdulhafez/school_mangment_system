package com.yazan.schoolMangment.Controllers;

import com.yazan.schoolMangment.Models.Teacher;
import com.yazan.schoolMangment.Services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class TeacherController {

    private static final Logger logger=Logger.getLogger(TeacherController.class.getName());

    @Autowired
    TeachersService teachersService;

    @GetMapping("/addTeacher")
    public String addTeacher(){
        Teacher teacher=new Teacher("Ahmmad","jordan","Ahmmad Hammed",36,"0785834251","Ahmmad@gmail.com",625.5,12);
        if(!teachersService.getTeachers().contains(teacher)){
            teachersService.addTeacher(teacher);
        }else{
            logger.info("the teacher is already added");
        }
        return "index";
    }

    @GetMapping("/teachers")
    public String getTeachers(Model model){
        List<Teacher> teachers= (List<Teacher>) teachersService.getTeachers();
        model.addAttribute("teachers",teachers);
        return "teachers";
    }
}
