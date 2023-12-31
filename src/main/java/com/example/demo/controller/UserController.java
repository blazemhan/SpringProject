package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserServices services;
	 @GetMapping("/users")//you can give this any name you want and after adding this string to the end of base url you can use this
	    public ResponseEntity<List<User>> getAllUsers() {
	        return ResponseEntity.ok(services.getUserList());
	    }
	 
	 @GetMapping("/user/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable int id) {
	        return ResponseEntity.ok().body(this.services.getUserbyId(id));
	    }

	    @PostMapping("/addUser")
	    public ResponseEntity<User> addUser(@RequestBody User user) {
	        return ResponseEntity.ok(this.services.createUser(user));
	    }

	    @PostMapping("/addUsers")
	    public ResponseEntity<List<User>> addUsers(@RequestBody List<User> list) {
	        return ResponseEntity.ok(this.services.createUserList(list));
	    }

	    @PutMapping("/updateUsers/")
	    public ResponseEntity<User> updateUser(@RequestBody User user) {
	        return ResponseEntity.ok().body(this.services.updateUserById(user));
	    }
	    @DeleteMapping("/deleteUsers/{id}")
	    public HttpStatus deleteUser(@PathVariable int id) {
	        this.services.deleteUserById(id);
	        return HttpStatus.OK;
	    }
	
	

}
