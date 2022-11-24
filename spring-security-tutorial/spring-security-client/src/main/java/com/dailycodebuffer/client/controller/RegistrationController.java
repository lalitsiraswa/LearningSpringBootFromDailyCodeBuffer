package com.dailycodebuffer.client.controller;
import com.dailycodebuffer.client.entity.User;
import com.dailycodebuffer.client.event.RegistrationCompleteEvent;
import com.dailycodebuffer.client.model.UserModel;
import com.dailycodebuffer.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
        User user = userService.registerUser(userModel);
        applicationEventPublisher.publishEvent(
                new RegistrationCompleteEvent(
                        user,
                        applicationUrl(request)
                ));
        return "Success";
    }
    @GetMapping("/VerifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
        String result = userService.validateVerificationToken(token);
        if(result.equalsIgnoreCase("valid")){
            return "User verified Successfully!";
        }
        return "Bad User!";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() +
                ":" + request.getServerPort() +
                request.getContextPath();
    }
}
