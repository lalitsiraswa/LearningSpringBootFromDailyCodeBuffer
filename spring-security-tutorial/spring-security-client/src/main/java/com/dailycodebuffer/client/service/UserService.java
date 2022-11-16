package com.dailycodebuffer.client.service;
import com.dailycodebuffer.client.entity.User;
import com.dailycodebuffer.client.model.UserModel;
import org.springframework.stereotype.Service;
public interface UserService {
    User registerUser(UserModel userModel);
}
