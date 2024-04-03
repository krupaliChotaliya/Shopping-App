package com.shopping.app.Repository;

import com.shopping.app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM users WHERE email = :email AND password = :password", nativeQuery = true)
    User login(String email, String password);
}
