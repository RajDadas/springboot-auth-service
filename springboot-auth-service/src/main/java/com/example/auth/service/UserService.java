package com.example.auth.service;
import com.example.auth.entity.User;
import com.example.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

@Autowired
private UserRepository repo;

@Autowired
private PasswordEncoder encoder;

public User register(User user){
user.setPassword(encoder.encode(user.getPassword()));
return repo.save(user);
}

public List<User> getUsers(){
return repo.findAll();
}

@Override
public UserDetails loadUserByUsername(String username){
User user = repo.findByUsername(username).orElseThrow();
return org.springframework.security.core.userdetails.User
.withUsername(user.getUsername())
.password(user.getPassword())
.roles(user.getRole())
.build();
}
}