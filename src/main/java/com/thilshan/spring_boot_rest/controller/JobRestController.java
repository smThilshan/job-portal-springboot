package com.thilshan.spring_boot_rest.controller;

import com.thilshan.spring_boot_rest.model.JobPost;
import com.thilshan.spring_boot_rest.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPost")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }
}

