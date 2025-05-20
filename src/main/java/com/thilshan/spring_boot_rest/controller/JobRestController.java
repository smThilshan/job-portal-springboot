package com.thilshan.spring_boot_rest.controller;

import com.thilshan.spring_boot_rest.model.JobPost;
import com.thilshan.spring_boot_rest.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin("*")

public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPost")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
}

