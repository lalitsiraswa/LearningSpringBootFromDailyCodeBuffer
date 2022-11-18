package com.dailycodebuffer.client.event.listener;
import com.dailycodebuffer.client.entity.User;
import com.dailycodebuffer.client.event.RegistrationCompleteEvent;
import com.dailycodebuffer.client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j // This is for logger
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification token for the user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        // Send mail to the user
        String url = event.getApplicationUrl()
                + "VerifyRegistration?token="
                + token;
        // We can implement sendVerificationEmail() method here.
        log.info("Click the link to verify you account: {}", url);
    }
}
