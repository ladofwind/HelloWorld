/**
 * 
 */
package com.publish.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.publish.model.User;

/**
 * @author Ryan Feng
 * 
 */
@Repository("userDao")
public interface UserDao {
	public User selectUser(User user);

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(int userId);

	public List selectUserLsit();

}
