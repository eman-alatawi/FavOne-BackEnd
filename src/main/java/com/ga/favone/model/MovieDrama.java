package com.ga.favone.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "MovieDrama")
public class MovieDrama {

	@Id
	@GeneratedValue
	private int id;

	private String title;

	private Date releaseYear;

	private String type;

	@Column(updatable = true, length = 5000)
	private String description;

	@Column(updatable = true, length = 2000)
	private String poster;

	private String duration;

	private int numOfEpisods;

	private String contentRating;

	private double score;

	@Column(name = "createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;

	@Column(name = "updatedAt", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;

	@ManyToMany
	@JoinTable(name = "actor_movieDramas", joinColumns = { @JoinColumn(name = "movieDrama_id") }, inverseJoinColumns = {
			@JoinColumn(name = "actor_id") })
	private Set<Actor> actors;

	@ManyToMany
	@JoinTable(name = "movieDrama_genders", joinColumns = {
			@JoinColumn(name = "movieDrama_id") }, inverseJoinColumns = { @JoinColumn(name = "gender_id") })
	private Set<Gender> genders;

	@OneToMany(mappedBy = "movieDrama", cascade = CascadeType.ALL)
	private Set<Episode> episodes;
	
	
	@OneToMany(mappedBy="movieDrama", cascade = CascadeType.ALL)
	 private Set<ImageGallery> imageGalleries;
	
	@ManyToOne
	@JoinColumn(name = "FK_OwnerId")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getNumOfEpisods() {
		return numOfEpisods;
	}

	public void setNumOfEpisods(int numOfEpisods) {
		this.numOfEpisods = numOfEpisods;
	}

	public String getContentRating() {
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
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

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public Set<Gender> getGenders() {
		return genders;
	}

	public void setGenders(Set<Gender> genders) {
		this.genders = genders;
	}

	public Set<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Set<Episode> episodes) {
		this.episodes = episodes;
	}

	public Set<ImageGallery> getImageGalleries() {
		return imageGalleries;
	}

	public void setImageGalleries(Set<ImageGallery> imageGalleries) {
		this.imageGalleries = imageGalleries;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	
}
