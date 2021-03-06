package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name ="user-service")
public interface UserClient {

    @GetMapping("/users")
    public List<User> getAll();

    @GetMapping("/users/{username}")
    public User findByUsername(@PathVariable(name = "username") String username);
}
