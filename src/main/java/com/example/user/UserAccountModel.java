/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.user;
import java.time.LocalDate; 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserAccountModel {
    private String name;
    private String surename;
    private LocalDate birthday;
    private LocalDate dateOfReg = LocalDate.now();
    
}
