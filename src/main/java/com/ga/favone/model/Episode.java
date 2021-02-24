package com.ga.favone.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Episode")
public class Episode {

	@Id
	@GeneratedValue
	private int id; 

	@Column(updatable = true, length = 2000)
	private String thumbnail;
	
	@Column(updatable = true, length = 2000)
	private String episodeVideoUrl;
	
	private int episodNum;

	@Column(name = "createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;

	@Column(name = "updatedAt", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;

	
	@ManyToOne
	@JoinColumn(name = "FK_MovieDramaId")
	private MovieDrama movieDrama;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public String getEpisodeVideoUrl() {
		return episodeVideoUrl;
	}


	public void setEpisodeVideoUrl(String episodeVideoUrl) {
		this.episodeVideoUrl = episodeVideoUrl;
	}


	public int getEpisodNum() {
		return episodNum;
	}


	public void setEpisodNum(int episodNum) {
		this.episodNum = episodNum;
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


//	public MovieDrama getMovieDrama() {
//		return movieDrama;
//	}


	public void setMovieDrama(MovieDrama movieDrama) {
		this.movieDrama = movieDrama;
	}
	
	
	
}
