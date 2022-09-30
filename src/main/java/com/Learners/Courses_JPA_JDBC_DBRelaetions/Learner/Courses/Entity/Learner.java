package com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity;

import javax.persistence.*;

@Entity
public class Learner {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;

    private String first_Name;
    private String last_Name;
    private String email;
    private String password;

    public Learner() {
    }

    public Learner(int id, Course course, String first_Name, String last_Name, String email, String password) {
        this.id = id;
        this.course = course;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getfirst_Name() {
        return first_Name;
    }

    public void setfirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getlast_Name() {
        return last_Name;
    }

    public void setlast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Learner{" +
                "id=" + id +
                ", course=" + course +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
