package com.ga.favone.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	private String userName;
	
	private String emailAddress;
	
	@Column(updatable = true ,length = 2000)
	private String profileImage;
	
	private String userRole;
	
	private String password;
	
	private String confirmPassword;
	
	private String oldPassword;
	
	
	@Column(name = "createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;

	@Column(name = "updatedAt", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	 private Set<MovieDrama> movieDramas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

//	public Set<MovieDrama> getMovieDramas() {
//		return movieDramas;
//	}

	public void setMovieDramas(Set<MovieDrama> movieDramas) {
		this.movieDramas = movieDramas;
	}
	
	
}
