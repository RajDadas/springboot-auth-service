package com.example.auth.controller;
import com.example.auth.entity.User;
import com.example.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

@Autowired
private UserService service;

@GetMapping
@PreAuthorize("hasRole('ADMIN')")
public List<User> getAll(){
return service.getUsers();
}
}