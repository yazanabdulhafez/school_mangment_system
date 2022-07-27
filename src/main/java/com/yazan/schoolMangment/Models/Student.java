package com.yazan.schoolMangment.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String grade;
    private int age;
    private String address;

    @OneToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "ID")
    private Parent parent;


    @ManyToMany
    @JoinTable(
            name = "Student_Course",
            joinColumns = @JoinColumn(name = "Student_ID"),
            inverseJoinColumns = @JoinColumn(name = "Course_ID")
    )
    private Set<Course> courses=new HashSet<>();

    public Student(){}


    public Student(String fullName, String email, String grade, int age, String address, Parent parent) {
        this.fullName = fullName;
        this.email = email;
        this.grade = grade;
        this.age = age;
        this.address = address;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", parent=" + parent +
                ", courses=" + courses +
                '}';
    }
}
