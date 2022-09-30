package com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Controller;

import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Course;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Learner;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourse(){    return courseService.getAllCourse();}

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id){    return courseService.getCourseById(id);}

    @GetMapping("/count")
    public long numberOfCourses(){ return courseService.numberOfCourse();}

    @GetMapping("/isExist/{id}")
    public String isCourseExistById(@PathVariable int id){    return courseService.isExistById(id);}

    @PostMapping
    public Course addCourse(@RequestBody Course course){    return courseService.addCourse(course);}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){   courseService.deleteById(id);}


}
