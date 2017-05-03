package com.userfront.service;

import java.sql.Date;
import java.util.List;

import com.userfront.domain.Author;
import com.userfront.domain.Book;
import com.userfront.domain.Checkout;
import com.userfront.domain.Genre;

// TODO: fix this for Book
public interface BookService {
	Book findByTitle(String title);
    Book findByIsbn(long isbn);
    Book findById(long id);
    List<Book> findAll();
    List<Book> findByGenre(Genre genre);
    List<Book> findByAuthor(Author author);
    List<Book> findByInStock(boolean available);
    void save (Book book);
    void deleteById (long id);

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
