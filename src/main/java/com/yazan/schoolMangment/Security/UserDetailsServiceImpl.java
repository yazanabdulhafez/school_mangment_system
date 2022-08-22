//package com.yazan.schoolMangment.Security;
//
//import com.yazan.schoolMangment.Models.Admin;
//import com.yazan.schoolMangment.Models.Student;
//import com.yazan.schoolMangment.Models.Teacher;
//import com.yazan.schoolMangment.Repositories.AdminRepository;
//import com.yazan.schoolMangment.Repositories.StudentRepository;
//import com.yazan.schoolMangment.Repositories.TeacherRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl  implements UserDetailsService {
//
//    @Autowired
//    AdminRepository adminRepository;
//
//    @Autowired
//    TeacherRepository teacherRepository;
//
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Admin admin=adminRepository.findByUsername(username);
//        Teacher teacher=teacherRepository.findByUsername(username);
//        Student student=studentRepository.findByUsername(username);
//
//        if(admin!=null){
//            return admin;
//        }else if(teacher !=null){
//            return teacher;
//        }else if(student !=null){
//            return student;
//        }else{
//            throw new UsernameNotFoundException("Dose not exist");
//        }
//    }
//
//
//}
