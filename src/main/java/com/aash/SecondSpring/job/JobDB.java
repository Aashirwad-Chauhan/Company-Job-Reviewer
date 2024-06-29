package com.aash.SecondSpring.job;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDB extends JpaRepository<Job, Long> { //<Entity, Primary key>


}
