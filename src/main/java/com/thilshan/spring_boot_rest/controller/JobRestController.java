package com.thilshan.spring_boot_rest.controller;

import com.thilshan.spring_boot_rest.model.JobPost;
import com.thilshan.spring_boot_rest.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());

    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());

    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return "Success";
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.search(keyword);
    }
}

