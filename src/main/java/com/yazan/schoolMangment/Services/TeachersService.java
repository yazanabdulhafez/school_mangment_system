package com.yazan.schoolMangment.Services;
import com.yazan.schoolMangment.Models.Teacher;
import com.yazan.schoolMangment.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachersService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public List<Teacher> getTeachers(){
        return (List<Teacher>) teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacher(Long id){
        return teacherRepository.findById(id);
    }

    public void deleteAllTeachers(){
        teacherRepository.deleteAll();
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }


    public Teacher updateTeacher(Teacher teacher) {
        Long teacherId = teacher.getId();

        Teacher teacher1 = teacherRepository.findById(teacherId).get();
        teacher1.setUsername(teacher.getUsername());
        teacher1.setPassword(teacher.getPassword());
        teacher1.setFullName(teacher.getFullName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setAge(teacher.getAge());
        return teacherRepository.save(teacher);
    }

}
