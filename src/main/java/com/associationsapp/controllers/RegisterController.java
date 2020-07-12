package com.associationsapp.controllers;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import javax.validation.Valid ;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.associationsapp.dto.ConfirmUserDto ;

import com.associationsapp.model.User ;
import com.associationsapp.repository.UserRepository ;

import java.util.Random;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class  RegisterController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository ;
    @PostMapping("/register")
    public User createUser (@Valid @RequestBody User user){


        if( user.getEmail().equals(userRepository.findByEmail(user.getEmail()))){
            return null ;
        }else {
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

          //  System.out.println(generatedString);


            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(user.getEmail());

            msg.setSubject("Email verification");
            msg.setText("Verification key : "+generatedString);

            javaMailSender.send(msg);
            user.setEnable(false);
            user.setConfirmation(generatedString);
            user.setRole("ROLE_MEMBER");
            return userRepository.save(user);
        }
    }
    @PostMapping("/verifyemail")
    public String createUser (@Valid @RequestBody ConfirmUserDto confirmUserDto){

               User user = userRepository.findByEmailAndConfirmation(confirmUserDto.getEmail(), confirmUserDto.getConfirmation()) ;
                if(user != null){
                    user.setEnable(true);
                    userRepository.save(user) ;
                    return  "success" ;
                }

                return "failure" ;

    }
}
