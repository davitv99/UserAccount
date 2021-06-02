/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.user;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davitv
 */
@RestController
@RequestMapping("/api/v1/useraccount")
@Slf4j
public class UserAccountControl {

    List<UserAccountModel> users = new ArrayList<>();

    @PostMapping("/create")
    public void addUser(@RequestBody UserAccountModel user) {
        if (user.getName() != null && user.getSurename() != null && user.getBirthday() != null && user.getDateOfReg() != null) {
            users.add(user);
            System.out.println("Congratulations Your Account is Created");
        } else {
            System.out.println("You should enter every field");
        }

    }

    @GetMapping("/user/details")
    public ResponseEntity getUser(@RequestParam Integer userId) {
        try {
            if (users.contains(users.get(userId))) {
                users.get(userId);
                return ResponseEntity.ok().body(users.get(userId));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User does not exists");
        }
        return ResponseEntity.badRequest().body("User does not exists");
    }

}
