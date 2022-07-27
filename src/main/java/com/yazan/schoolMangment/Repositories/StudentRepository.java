package com.yazan.schoolMangment.Repositories;

import com.yazan.schoolMangment.Models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
