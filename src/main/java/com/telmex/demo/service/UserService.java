package com.telmex.demo.service;

import com.telmex.demo.dto.UserRequest;
import com.telmex.demo.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse saveUser(UserRequest userRequest);

    UserResponse getUser();

    List<UserResponse> getAllUser();


}
