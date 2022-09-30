package com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Controller;

import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Course;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Learner;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Service.CourseService;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/learners")
public class LearnerController {

    @Autowired
    private LearnerService learnerService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Learner> getAllLeaners(){    return learnerService.getAllLearner();}

    @GetMapping("/{id}")
    public Learner getLeanerById(@PathVariable int id){    return learnerService.getLearnerById(id);}

    @GetMapping("/count")
    public long numberOfLearners(){ return learnerService.numberOfLearner();}

    @GetMapping("/isExist/{id}")
    public String isLeanerExistById(@PathVariable int id){    return learnerService.isExistById(id);}

    @PostMapping
    public Learner addLearner(@RequestBody Learner learner){    return learnerService.addLearner(learner);}

    @PutMapping("/getCourseByLearnerId/{id}")
    public Course getCourseByLearnerId(@PathVariable int id) {  return learnerService.getCourseByLearner(id);}

    @PutMapping("/course/{c_id}/leaner/{id}")
    public Learner assignCourseToLearner(@PathVariable int c_id, @PathVariable int id)
    {     return
            learnerService.assignProfile(
                    id,
                    courseService.getCourseById(c_id)
            );
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){   learnerService.deleteById(id);}



    // -------------------------------- Queries Based Rest API --------------------------------------
    @PostMapping(value = "/findByEmailAndLastName")
    public List<Learner> findByEmailAndLastName(@RequestBody Map<String,String> response){
        //response.get("email").toString(),response.get("last_name").toString()
        return learnerService.findByEmailAddressAndLastname(response.get("email").toString(),response.get("last_name").toString());
    }

    @PostMapping(value = "/findDistinctLeanerByLastnameOrFirstname")
    public List<Learner> findDistinctLeanerByLastnameOrFirstname(@RequestBody Map<String,String> response){
        //response.get("email").toString(),response.get("last_name").toString()
        return learnerService.findDistinctLeanerByLastnameOrFirstname(response.get("first_name").toString(),response.get("last_name").toString());
    }
    @PostMapping(value = "/findByLastnameIgnoreCase")
    public List<Learner> findByLastnameIgnoreCase(@RequestBody Map<String,String> response){
        //response.get("email").toString(),response.get("last_name").toString()
        return learnerService.findByLastnameIgnoreCase(response.get("last_name").toString());
    }
    @PostMapping(value = "/findByLastnameOrderByFirstnameAsc")
    public List<Learner> findByLastnameOrderByFirstnameAsc(@RequestBody Map<String,String> response){
        //response.get("email").toString(),response.get("last_name").toString()
        return learnerService.findByLastnameOrderByFirstnameAsc(response.get("last_name").toString());
    }

}
