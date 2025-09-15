package com.kams.portfolio.user;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository users;

    public UserController(UserRepository users) {
        this.users = users;
    }

    @GetMapping
    public List<User> all() {
        return users.findAll();
    }

    @PostMapping
    public User create(@RequestBody User u) {
        return users.save(u);
    }
}
