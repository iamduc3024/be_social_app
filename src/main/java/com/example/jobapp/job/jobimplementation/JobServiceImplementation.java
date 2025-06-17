package com.example.jobapp.job.jobimplementation;

import com.example.jobapp.job.Job;
import com.example.jobapp.job.JobRepository;
import com.example.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplementation implements JobService {
    private JobRepository jobRepository;

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findALL() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
//        job.setId(++id);
//        jobs.add(job);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
//        for (Long i = 0L; i < jobs.size(); i++) {
//            if (jobs.get(Math.toIntExact(i)).getId().equals(id)) {
//                return jobs.get(Math.toIntExact(i));
//            }
//        }
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJobById(Long id) {
//        for (Long i = 0L; i < jobs.size(); i++) {
//            if (jobs.get(Math.toIntExact(i)).getId().equals(id)) {
//                jobs.remove(jobs.get(Math.toIntExact(i)));
//                return true;
//            }
//        }
//        return false;
        jobRepository.deleteById(id);
    }

    @Override
    public void updateJob(Long id, Job updatedJob) {
        Optional<Job> jobNeedToBeUpdated = jobRepository.findById(id);
        if (jobNeedToBeUpdated.isPresent()) {
            jobNeedToBeUpdated.get().setTitle(updatedJob.getTitle());
            jobNeedToBeUpdated.get().setDescription(updatedJob.getDescription());
            jobNeedToBeUpdated.get().setMinSalary(updatedJob.getMinSalary());
            jobNeedToBeUpdated.get().setMaxSalary(updatedJob.getMaxSalary());
            jobNeedToBeUpdated.get().setLocation(updatedJob.getLocation());

            jobRepository.save(jobNeedToBeUpdated.get()); // Lưu thay đổi vào database
        }
    }
}
