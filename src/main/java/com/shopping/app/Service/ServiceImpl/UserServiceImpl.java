package com.shopping.app.Service.ServiceImpl;

import com.shopping.app.Repository.UserRepository;
import com.shopping.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
}
