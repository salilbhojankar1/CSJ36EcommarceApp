package service;

import model.User;

public interface UserService {
	public User addUser(User user);
	public User getUserById(int userId);
	public User signIn(String username, String password);
}
