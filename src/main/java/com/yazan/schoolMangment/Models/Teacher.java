package com.yazan.schoolMangment.Models;

import javax.persistence.*;
;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private int age;
    private String mobileNumber;
    private String email;
    private double salary;
    private int experience;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="subject_id", referencedColumnName = "id")
    private Course course;

    public Teacher(){}

    public Teacher(String fullName, int age, String mobileNumber, String email, double salary, int experience) {
        this.fullName = fullName;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.salary = salary;
        this.experience = experience;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                ", course=" + course +
                '}';
    }
}
