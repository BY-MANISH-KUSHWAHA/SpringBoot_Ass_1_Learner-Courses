package com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Service;

import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Course;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Learner;
import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {

    @Autowired
    LearnerRepository learnerRepository;

    @Transactional
    public List<Learner> findByEmailAddressAndLastname(String email, String last_name){
         return learnerRepository.findByEmailAddressAndLastname(email,last_name);
    }

    @Transactional
    public List<Learner> findDistinctLeanerByLastnameOrFirstname(String first_name, String last_name){
        return learnerRepository.findDistinctLeanerByLastnameOrFirstname(first_name,last_name);
    }

    @Transactional
    public List<Learner> findByLastnameIgnoreCase( String last_name){
        return learnerRepository.findByLastnameIgnoreCase(last_name);
    }

    @Transactional
    public List<Learner> findByLastnameOrderByFirstnameAsc(String last_name){
        return learnerRepository.findByLastnameOrderByFirstnameAsc(last_name);
    }

    public List<Learner> getAllLearner(){ return learnerRepository.findAll();}

    public Learner getLearnerById(@PathVariable("id") int id){
        Optional<Learner> learner = learnerRepository.findById(id);
        if(learner.isEmpty()) throw  new RuntimeException("Make Custom exception for Id not exist");
        return learner.get();
    }

    public Learner addLearner(Learner learner){ return learnerRepository.save(learner);}

    public long numberOfLearner(){   return learnerRepository.count();}

    public void deleteById(@PathVariable("id") int id){
        Optional<Learner> learner = learnerRepository.findById(id);
        if(learner.isEmpty()) throw  new RuntimeException("Make Custom exception for Id not exist");
        learnerRepository.delete(learner.get());
    }

    public String isExistById(@PathVariable("id") int id){
        Optional<Learner> learner = learnerRepository.findById(id);
        return "Learner{" +
                "id=" + id +
                ", isExist=" + learner.isPresent()+
                '}';
    }

    public Learner assignProfile(int id, Course course){
        Learner learner = learnerRepository.findById(id).get();
        learner.setCourse(course);
        return learnerRepository.save(learner);
    }

    public Course getCourseByLearner(int id) {
        Optional<Learner> learner = learnerRepository.findById(id);
        if(learner.isEmpty()) throw  new RuntimeException("Make Custom exception for Id not exist");
        return learner.get().getCourse();
    }
}
