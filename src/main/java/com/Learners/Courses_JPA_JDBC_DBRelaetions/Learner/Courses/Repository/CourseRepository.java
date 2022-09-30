package com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Repository;

import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
