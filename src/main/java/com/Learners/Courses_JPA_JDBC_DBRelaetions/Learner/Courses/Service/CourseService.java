package com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Service;

import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Course;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Learner;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Repository.CourseRepository;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourse(){ return courseRepository.findAll();}

    public Course getCourseById(@PathVariable("id") int id){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()) throw  new RuntimeException("Make Custom exception for Id not exist");
        return course.get();
    }

    public Course addCourse(Course course){ return courseRepository.save(course);}

    public long numberOfCourse(){   return courseRepository.count();}

    public void deleteById(@PathVariable("id") int id){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()) throw  new RuntimeException("Make Custom exception for Id not exist");
        courseRepository.delete(course.get());
    }

    public String isExistById(@PathVariable("id") int id){
        Optional<Course> course = courseRepository.findById(id);
        return "{" +
                "\"id=\"" + id +
                ", \"isExist\"=" + course.isPresent()+
                '}';
    }
}
