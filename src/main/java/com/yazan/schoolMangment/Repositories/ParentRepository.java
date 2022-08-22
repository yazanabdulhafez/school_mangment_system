package com.yazan.schoolMangment.Repositories;

import com.yazan.schoolMangment.Models.Parent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends CrudRepository<Parent,Long> {
}
