package com.johurulislam.controller;

import com.johurulislam.model.User;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class MainController {
    @GetMapping("/userinfo")
    public User userInfo() {
        User userInfoList=new User();
        userInfoList.setFullName("johurulislam");
        userInfoList.setEmail("johurulislam@gmail.com");
        userInfoList.setPassword("sakline54321");
        userInfoList.setAge(23);
        return userInfoList;
    }
    @PostMapping("/submit/{fullName}")
    public ResponseEntity<?> submit(@PathVariable String fullName, @RequestParam String email,
                                    @RequestBody User user) {
        System.out.println(fullName+" "+email+" "+user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> user(@PathVariable Integer id){
        User user=new User("name",null,null,null);
        if(id==123){
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }
        else {
            Map<String,Object>errorMassage=new HashMap<>();
            errorMassage.put("message","Invalid ID");
            return new ResponseEntity<>(errorMassage,HttpStatus.BAD_REQUEST);
        }

    }

}
