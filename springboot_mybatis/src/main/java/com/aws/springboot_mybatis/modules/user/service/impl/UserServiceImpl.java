package com.aws.springboot_mybatis.modules.user.service.impl;

import com.aws.springboot_mybatis.dao.UserMapper;
import com.aws.springboot_mybatis.entity.User;
import com.aws.springboot_mybatis.modules.user.dto.UserDTO;
import com.aws.springboot_mybatis.modules.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserById(String user_id) {
        User userDO = userMapper.selectByPrimaryKey(Integer.valueOf(user_id));
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO,userDTO);
        return userDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void insertUser(UserDTO userDTO) {
        User userDO = new User();
        BeanUtils.copyProperties(userDTO, userDO);
        userMapper.insert(userDO);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateUser(UserDTO userDTO) {
        User userDO = new User();
        BeanUtils.copyProperties(userDTO,userDO);
        userMapper.updateByPrimaryKey(userDO);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteUser(String user_id) {
        userMapper.deleteByPrimaryKey(Integer.valueOf(user_id));
    }
}
