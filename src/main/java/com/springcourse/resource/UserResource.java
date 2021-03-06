package com.springcourse.resource;

import com.springcourse.domain.Request;
import com.springcourse.domain.User;
import com.springcourse.dto.UserLoginDto;
import com.springcourse.service.RequestService;
import com.springcourse.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="users")
public class UserResource {

    private final UserService userService;
    private final RequestService requestService;

    public UserResource(UserService userService, RequestService requestService) {
        this.userService = userService;
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody  User user){
        User createdUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable(name="id") Long id, @RequestBody  User user){
        user.setId(id);
        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable(name="id") Long id){
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> listAll(){
        List<User> users = userService.listAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}/requests")
    public ResponseEntity<List<Request>> listAllRequestsById(@PathVariable(name="id") Long id){
        List<Request> users = requestService.listAllByOwnerId(id);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLoginDto user){
        User loggedUer = userService.login(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(loggedUer);
    }
}
