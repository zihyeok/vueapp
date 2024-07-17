package com.folder.app.controller;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;
import com.folder.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8800")
@RestController
public  class DataController {

    @GetMapping("/")
    public String home() {
        return  "Data 준비중 ...";
    }

    @GetMapping("/api")
    public String api() {
        return  "Api Data 준비중 ...";
    }

    @Autowired UserService uService;

    @PostMapping("/findAll")
    public ResultDTO findAll() {

        return uService.findAll();
    }

    @PostMapping("/editById")
    public ResultDTO editById(@RequestBody UserDTO uDto) {
        return uService.editById(uDto);
    }

    @DeleteMapping("/delete")
    public ResultDTO delete(@RequestParam("no") int no) {

        return uService.delete(no);
    }

    @PostMapping("/save")
    public ResultDTO save(@RequestBody UserDTO uDto) {

        return uService.save(uDto);
    }

}