package com.initialize.api;

import com.initialize.entity.User;
import com.initialize.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setId("E00001");
        user.setBirthDay(Calendar.getInstance().getTime());
        user.setName("First");
        user.setSurname("Entity");
        user.setAddress("No where");
        userRepository.save(user);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search) {
        List<User> userlist = userRepository.getByCustomQuery(search);
        return ResponseEntity.ok(userlist);
    }
}
