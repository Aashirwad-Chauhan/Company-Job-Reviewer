package com.aash.SecondSpring.job.implementation;

import com.aash.SecondSpring.job.Job;
import com.aash.SecondSpring.job.JobDB;
import com.aash.SecondSpring.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//**Note** - All the second implementation are according to JPA.

@Service
public class JobServiceImpl implements JobService {
//    private final List<Job> jobs = new ArrayList<>();
    private final JobDB repo;

    public JobServiceImpl(JobDB repo) {
        this.repo = repo;
    }

//    private Long nextId = 1L;
    @Override
    public List<Job> findAll() {
        return repo.findAll();
    }

    @Override
    public void createJob(Job job) {
//        job.setId(nextId++);
        repo.save(job);
    }

    @Override
    public Job getJobById(Long jodId) {
//        for(Job job: jobs){
//            if(job.getId().equals(jodId)) return job;
//        }
//        return null;

        return repo.findById(jodId).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long Id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()) {
//            Job job = iterator.next();
//            if (job.getId().equals(Id)) {
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;

        try{
            repo.deleteById(Id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long Id, Job params) {
//        for(Job job: jobs){
//            if(job.getId().equals(Id)) {
//                job.setTitle(params.getTitle());
//                job.setDesc(params.getDesc());
//                job.setMinSalary(params.getMinSalary());
//                job.setMaxSalary(params.getMaxSalary());
//                job.setLocation(params.getLocation());
//
//                return true;
//            }
//        }
//        return false;

        Optional<Job> jobOptional = repo.findById(Id);
         if(jobOptional.isPresent()) {
             Job job = jobOptional.get();
            job.setTitle(params.getTitle());
            job.setDesc(params.getDesc());
            job.setMinSalary(params.getMinSalary());
            job.setMaxSalary(params.getMaxSalary());
            job.setLocation(params.getLocation());
            repo.save(job);
            return true;
         }
         return false;
    }

}
