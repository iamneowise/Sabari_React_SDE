package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.model.UserModel;
import com.example.tempmodel.UserTempModel;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SignupController {


}
