package com.shopping.app.Service;

import com.shopping.app.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User login(String email, String password);
}
