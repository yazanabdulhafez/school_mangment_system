package com.yazan.schoolMangment.Repositories;

import com.yazan.schoolMangment.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends CrudRepository<Student,Long> , PagingAndSortingRepository<Student,Long> {
    Student findByUsername(String username);
}
