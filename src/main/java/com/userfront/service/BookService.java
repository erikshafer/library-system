package com.userfront.service;

import java.util.List;

import com.userfront.domain.Book;

// TODO: fix this for Book
public interface BookService {
	Book findByTitle(String title);
    Book findByIsbn(long isbn);
    Book findById(long id);
    List<Book> findAll();
    List<Book> findByGenre(int genre);
    void save (Book book);

//    boolean checkUserExists(String username, String email);
//
//    boolean checkUsernameExists(String username);
//
//    boolean checkEmailExists(String email);
//    
//    void save (User user);
//    
//    User createUser(User user, Set<UserRole> userRoles);
//    
//    User saveUser (User user); 
//    
//    List<User> findUserList();
//
//    void enableUser (String username);
//
//    void disableUser (String username);
}
