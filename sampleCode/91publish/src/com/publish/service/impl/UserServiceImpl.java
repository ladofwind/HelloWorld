package com.publish.service.impl;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.publish.dao.UserDao;
import com.publish.model.User;
import com.publish.service.UserService;

@Controller
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public @ResponseBody
	String userLogin(@RequestBody String request) {
		System.out.println("userLogin method was called");
		String id = (String) JSON.parseObject(request).get("id");
		String username = (String) JSON.parseObject(request).get("username");
		String password = (String) JSON.parseObject(request).get("password");
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		userDao.insertUser(user);

		return "Hello," + username;
	}

}
