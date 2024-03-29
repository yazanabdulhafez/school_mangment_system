package com.yazan.schoolMangment.Repositories;

import com.yazan.schoolMangment.Models.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher,Long> {
    Teacher findByUsername(String username);
}
