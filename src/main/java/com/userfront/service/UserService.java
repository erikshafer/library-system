package com.userfront.service;

import java.util.List;
import java.util.Set;

import com.userfront.domain.User;

public interface UserService {
	User findByUsername(String username);
    User findByEmail(String email);

    boolean checkUserExists(String username, String email);
    boolean checkUsernameExists(String username);
    boolean checkEmailExists(String email);
    
    void save (User user);
    
    //Not yet...
    //void saveUser (User user); 
    
}
