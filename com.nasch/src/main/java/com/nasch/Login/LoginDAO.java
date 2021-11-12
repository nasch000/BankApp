
package com.nasch.Login;

import java.util.*;

public interface LoginDAO {
	List<Login> getLogins();
	void addLogin(Login login);
	void updateLogin(Login login);
	void deleteLogin(Login login);
	
}
