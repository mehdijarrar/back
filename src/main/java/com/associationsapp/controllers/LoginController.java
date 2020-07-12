package com.associationsapp.controllers;


import com.associationsapp.model.JwtUser;
import com.associationsapp.repository.UserRepository;
import com.associationsapp.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.associationsapp.model.User ;
import java.util.HashMap;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private UserRepository userRepository ;
    private JwtGenerator jwtGenerator;

    public LoginController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public HashMap generate(@RequestBody final User user) {


        User u = userRepository.findById(userRepository.findByEmailID(user.getEmail())) .orElse(null) ;

        JwtUser jwtUser = new JwtUser() ;
        if( user.getEmail().equals(userRepository.findByEmailAndPassword( user.getEmail() , user.getPassword() )) && u.getEnable() == true){
            jwtUser.setId(userRepository.findByEmailID(user.getEmail()));
            jwtUser.setRole(userRepository.findByEmailRole(user.getEmail()));
            jwtUser.setUserName(user.getEmail());

            HashMap<String, String> map = new HashMap<>();

            map.put("token", jwtGenerator.generate(jwtUser) );
            map.put("id", String.valueOf(jwtUser.getId())) ;
            map.put("role", jwtUser.getRole()) ;
            return map ;
        }else {
            return null ;
        }



    }
}
