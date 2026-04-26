package com.rentease.controller;


import com.rentease.entity.UserEntity;
import com.rentease.model.UserDTO;
import com.rentease.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserEntity onboardingUser(@RequestBody UserDTO userDTO){
        UserEntity data=userService.saveUser(userDTO);
        return data;
    }
    /*@PostMapping("/login")
    public String userLogin(@RequestBody UserDTO userDTO){
        String userId=userDTO.getUserId();
        String password=userDTO.getPassword();
        if (userId.equals("admin")){
            if (userId.equals("admin")&&password.equals("12345")){
                return "login success";
            }
            else {
                return "Invalid login";
            }
        }
        else {
            UserEntity loginUser=userService.loginUser(userId, password);
            if(loginUser!=null)
            {
                return "loginUser";

            }
            return "InValid login credential";
        }
    }*/
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserDTO userDTO){

        System.out.println("UserId: " + userDTO.getUserId());

        String userId = userDTO.getUserId();
        String password = userDTO.getPassword();

        Map<String, String> response = new HashMap<>();

        if(userId == null || password == null){
            response.put("message", "UserId or Password is missing");
            return ResponseEntity.badRequest().body(response);
        }

        if("admin".equals(userId) && "12345".equals(password)){
            response.put("message", "Login Successful");
            response.put("role", "ADMIN");
            return ResponseEntity.ok(response);
        }

        UserEntity loginUser = userService.loginUser(userId, password);

        if(loginUser != null){
            response.put("message", "Login Successful");
            response.put("role", "USER");
            return ResponseEntity.ok(response);
        }

        response.put("message", "Invalid login credentials");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){
        UserEntity user= userService.getUserById(id);
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
   /* @PostMapping("/saveUser")
    public String saveUser(User user){
        userService.saveUser(new UserDTO());

        return "redirect:/login";
    }*/
   @GetMapping("/logout")
   public String logout(HttpSession session){
       session.invalidate();
       return "Logout Success";
   }
}
