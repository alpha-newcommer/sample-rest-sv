package com.example.samplerestsv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.samplerestsv.mapper.UserMapper;
import com.example.samplerestsv.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUser(int id) {
		return userMapper.get(id);
	}

}
