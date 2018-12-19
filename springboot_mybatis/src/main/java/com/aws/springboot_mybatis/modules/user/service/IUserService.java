package com.aws.springboot_mybatis.modules.user.service;

import com.aws.springboot_mybatis.modules.user.dto.UserDTO;

public interface IUserService {

    UserDTO getUserById(String user_id);

    void insertUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(String user_id);
}
