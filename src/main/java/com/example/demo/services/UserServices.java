package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
	
	@Autowired
	UserRepository userRep;
	
	public User createUser(User user) {
		return userRep.save(user);
	}
	
	public List<User> createUserList(List<User> list){
		return userRep.saveAll(list);
	}
	
	public List<User> getUserList(){
		
		return userRep.findAll();
		}
	public User getUserbyId(int id) {
		return userRep.findById(id).orElse(null);
		
	}

	 public User updateUserById(User user) {
	        Optional<User> userFound = userRep.findById(user.getId());

	        if (userFound.isPresent()) {
	            User userUpdate = userFound.get();
	            userUpdate.setFname(user.getFname());
	            userUpdate.setLname(user.getLname());
	            userUpdate.setAge(user.getAge());

	            return userRep.save(user);
	        } else {
	            return null;
	        }
	        }
	        public String deleteUserById(int id) {
	            userRep.deleteById(id);
	            return "User "+ id +" deleted";
	        }
	 
}
