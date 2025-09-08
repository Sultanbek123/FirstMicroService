package kz.kenzhakhimov.firstmicroservice.controllers;

import kz.kenzhakhimov.firstmicroservice.dto.UsersDTO;
import kz.kenzhakhimov.firstmicroservice.entities.Users;
import kz.kenzhakhimov.firstmicroservice.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private MyUserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsersDTO usersDTO){
        userService.register(usersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Register success");
    }
}
