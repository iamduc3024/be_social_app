package com.example.jobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findALL();
    void createJob(Job job);
    Job getJobById(Long id);
    void deleteJobById(Long id);
    void updateJob(Long id, Job updatedJob);
}
