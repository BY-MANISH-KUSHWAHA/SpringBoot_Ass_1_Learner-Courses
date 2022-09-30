package com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Repository;

import com.Learners.Courses_JPA_JDBC_DBRelaetions.Learner.Courses.Entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnerRepository extends JpaRepository<Learner,Integer> {

    @Modifying
    @Query("SELECT l FROM Learner l Where l.email = :email AND l.last_Name = :last_name" )
    List<Learner> findByEmailAddressAndLastname(@Param("email") String email, @Param("last_name") String last_name );

    @Modifying
    @Query("SELECT DISTINCT l FROM Learner l Where l.first_Name = :first_name OR l.last_Name = :last_name")
    List<Learner> findDistinctLeanerByLastnameOrFirstname(@Param("first_name") String firstname, @Param("last_name") String lastname );

    @Modifying
    @Query("SELECT l FROM Learner l Where UPPER(l.last_Name) = UPPER(:last_name)")
    List<Learner> findByLastnameIgnoreCase( @Param("last_name") String last_name );

    @Modifying
    @Query("SELECT l FROM Learner l Where l.last_Name = :last_name ORDER BY l.first_Name ASC")
    List<Learner> findByLastnameOrderByFirstnameAsc(@Param("last_name") String last_name );




}
