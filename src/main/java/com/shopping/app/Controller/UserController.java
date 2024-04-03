package com.shopping.app.Controller;

import com.shopping.app.Model.User;
import com.shopping.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestParam String email,@RequestParam String password){
        return userService.login(email,password);
    }

}
