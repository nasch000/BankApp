
package com.nasch.Account;

import java.util.*;

public interface AccountDAO {
	List<Account> getAccounts();
	void addAccount(Account account);
	void updateAccount(Account account);
	void deleteAccount(Account account);
	
}
