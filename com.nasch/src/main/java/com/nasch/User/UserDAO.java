
package com.nasch.User;

import java.util.*;

public interface UserDAO {
	List<User> getUsers();
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	
}
