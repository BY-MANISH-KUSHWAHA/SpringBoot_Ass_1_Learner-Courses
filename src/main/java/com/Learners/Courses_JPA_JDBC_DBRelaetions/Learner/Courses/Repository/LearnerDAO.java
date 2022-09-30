package com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Repository;

import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Course;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LearnerDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // READ
    public List<Learner> getAllLearner(){
        String getLearnerQuery = "SELECT * FROM Learner";
        return  jdbcTemplate.query(getLearnerQuery,new BeanPropertyRowMapper<Learner>(Learner.class));
    }

    // READ BY ID
    public Learner getLearnerByID(int ID){
        String getLearnerByIDQuery = "SELECT * FROM Learner WHERE ID = ?";
        return  jdbcTemplate.queryForObject(getLearnerByIDQuery,new BeanPropertyRowMapper<Learner>(Learner.class),new Object[]{ID});
    }

    // CREATE
    public int insertLearner(Learner leaner){
        String insertLearnerQuery = "INSERT INTO Learner VALUES(?,?,?,?,?,?)";
        // will return 1 after success and 0.

        return  jdbcTemplate.update(insertLearnerQuery, new Object[]{
                leaner.getId(),
                leaner.getCourse().getId(),
                leaner.getfirst_Name(),
                leaner.getlast_Name(),
                leaner.getEmail(),
                leaner.getPassword()
        });
    }

    // UPDATE
    public int updateLearner(Learner learner){
        String updateLearnerQuery = "UPDATE Learner "+
                "SET Course_Id = ?, FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PASSWORD = ?"+
                "Where ID = ?";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(updateLearnerQuery,
                new Object[]{
                        learner.getId(),
                        learner.getCourse().getId(),
                        learner.getfirst_Name(),
                        learner.getlast_Name(),
                        learner.getEmail(),
                        learner.getPassword()

                });
    }

    // Delete
    public int deleteLearner(int ID){
        String deleteLearnerQuery = "DELETE FROM Learner WHERE ID = ?;";
        // will return 1 after success and 0.
        return  jdbcTemplate.update(deleteLearnerQuery, ID);
    }
}
