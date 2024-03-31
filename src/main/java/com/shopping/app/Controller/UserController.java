package com.shopping.app.Controller;

import com.shopping.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;
}
