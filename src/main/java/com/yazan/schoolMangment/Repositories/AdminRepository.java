package com.yazan.schoolMangment.Repositories;

import com.yazan.schoolMangment.Models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {
    Admin findByUsername(String username);
}
