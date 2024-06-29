package com.aash.SecondSpring.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService js;

    public JobController(JobService js) {
        this.js = js;
    }

    @GetMapping  //using this instead @GetMapping("/jobs"), because we are using @RequestMapping("/jobs") as base
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(js.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        js.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long Id){
        Job job = js.getJobById(Id);
        if(job!=null) return new ResponseEntity<>(job, HttpStatus.OK );

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{Id}")
    public  ResponseEntity<String> deleteJob(@PathVariable Long Id){
        boolean deleted = js.deleteJobById(Id);
        if(deleted) return new ResponseEntity<>("Job deleted!", HttpStatus.OK);

        return new ResponseEntity<>("Job Not Found!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{Id}") // instead of this you can also chain it like node since all are working /jobs, using RequestMapping
    //@RequestMapping(value="/jobs/{id}", method=RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long Id, @RequestBody Job params){
        boolean updated = js.updateJobById(Id, params);

        if(updated) return new ResponseEntity<>("Job Updated", HttpStatus.OK);

        return new ResponseEntity<>("Job Not Found!", HttpStatus.NOT_FOUND);
    }
}


