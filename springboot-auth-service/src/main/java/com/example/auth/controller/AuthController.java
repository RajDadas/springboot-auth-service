package com.example.auth.controller;
import com.example.auth.entity.User;
import com.example.auth.service.UserService;
import com.example.auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

@Autowired
private AuthenticationManager manager;

@Autowired
private JwtUtil jwtUtil;

@Autowired
private UserService service;

@PostMapping("/register")
public User register(@RequestBody User user){
return service.register(user);
}

@PostMapping("/login")
public String login(@RequestBody User user){
manager.authenticate(
new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
);
return jwtUtil.generateToken(user.getUsername());
}
}