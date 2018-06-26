package com.cyj.core.service;

import com.cyj.core.po.User;

public interface UserService {
	public void save(User u);
	public User findByEmail(String email);
	public User findById(int id);
	public void update(User u);
}
