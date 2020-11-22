package com.spring.coding.api;

import com.spring.coding.entity.User;
import com.spring.coding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("First");
        user.setSurname("Log");
        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> add() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
