//package com.company.service;
//
//import com.company.domain.User;
//import com.company.domain.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    public User getUserById(long id) {
//        return userRepository.findOne(id);
//    }
//
//    public List<User> getAllUsers() {
//        return (List<User>) userRepository.findAll();
//    }
//}
