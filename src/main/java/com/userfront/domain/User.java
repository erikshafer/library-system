package com.userfront.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements UserDetails {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", nullable = false, updatable = false)
	private Long userId;			// incrementing value
	private String username;		// user defined
	private String password;		// user defined
	private String firstName;		// user defined
	private String lastName;		// user defined
	
    @Column(name = "email", nullable = false, unique = true)
	private String email;			// user defined
	private Long nuId;				// user defined (NUID)
	private Integer userGroupId;	// auto-assigned by application
	private boolean enabled=true;	// automatically enabled, can be disabled by admin
	
    @OneToOne
    private PrimaryAccount primaryAccount;
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private List<Appointment> appointmentList;
    
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnore
//	private List<BooksCheckedOut> booksInCart;
    
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnore
//	private List<BooksCheckedOut> booksCheckedOutList;

	// toString
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", nuId=" + nuId + ", userGroupId="
				+ userGroupId + ", enabled=" + enabled + "]";
	}
	
	// Getters and Setters
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNuId() {
		return nuId;
	}

	public void setNuId(Long nuId) {
		this.nuId = nuId;
	}

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

//	public List<BooksCheckedOut> getBooksInCart() {
//		return booksInCart;
//	}
//    
//	public void setBooksInCart(List<BooksCheckedOut> booksInCart) {
//		this.booksInCart = booksInCart;
//	}
//
//	public List<BooksCheckedOut> getBooksCheckedOutList() {
//		return booksCheckedOutList;
//	}
//
//	public void setBooksCheckedOutList(List<BooksCheckedOut> booksCheckedOutList) {
//		this.booksCheckedOutList = booksCheckedOutList;
//	}
}
