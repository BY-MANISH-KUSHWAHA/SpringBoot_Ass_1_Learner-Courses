package com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Repository;

import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class CourseDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // READ
    public List<Course> getAllCourses(){
        String getCourseQuery = "SELECT * FROM Course";
        return  jdbcTemplate.query(getCourseQuery,new BeanPropertyRowMapper<Course>(Course.class));
    }

    // READ BY ID
    public Course getCourseByID(int ID){
        String getCourseByIDQuery = "SELECT * FROM Course WHERE ID = ?";
       return  jdbcTemplate.queryForObject(getCourseByIDQuery,new BeanPropertyRowMapper<Course>(Course.class),new Object[]{ID});
    }

    // CREATE
    public int insertCourse(Course course){
        String insertCourseQuery = "INSERT INTO Course VALUES(?,?,?)";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(insertCourseQuery, new Object[]{
                course.getId(),
                course.getName(),
                course.getDescription()
        });
    }

    // UPDATE
    public int updateCourse(Course course){
        String updateCourseQuery = "UPDATE Course "+
                "SET NAME = ?, DESCRIPTION = ?"+
                "Where ID = ?";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(updateCourseQuery,
                new Object[]{
                        course.getId(),
                        course.getName(),
                        course.getDescription()
                });
    }

    // Delete
    public int deleteCourse(int ID){
        String deleteCourseQuery = "DELETE FROM Course WHERE ID = ?;";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(deleteCourseQuery, ID);
    }

}
