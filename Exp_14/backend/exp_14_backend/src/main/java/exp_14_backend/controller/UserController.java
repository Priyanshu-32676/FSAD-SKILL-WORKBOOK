package exp_14_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import exp_14_backend.model.User;
import exp_14_backend.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository repo;

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User u = repo.findByUsername(user.getUsername());

        if (u != null && u.getPassword().equals(user.getPassword())) {
            return u;
        }
        return null;
    }

    // PROFILE
    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return repo.findByUsername(username);
    }
}