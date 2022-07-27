package com.yazan.schoolMangment.Models;

import javax.persistence.OneToMany;
import java.util.Set;

public class Course {


    private Long id;

    private String name;
    private int chapters;

    @OneToMany(mappedBy = "course")
    private Set<Teacher> teachers;

    public Course() {

    }

    public Course(String name, int chapters) {
        this.name = name;
        this.chapters = chapters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chapters=" + chapters +
                ", teachers=" + teachers +
                '}';
    }
}
