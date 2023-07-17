package com.barnaclaebit.project.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String title;
	private Integer launchYear;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	
	@Column(columnDefinition = "TEXT")
	private String shortDescription;
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	
	
	public Game() {
		
	}



	public Game(long id, String title, Integer launchYear, String genre, String platforms, Double score, String imgUrl,
			String shortDescription, String longDescription) {
		super();
		this.id = id;
		this.title = title;
		this.launchYear = launchYear;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}



	@Override
	public int hashCode() {
		return Objects.hash(genre, id, imgUrl, longDescription, platforms, score, shortDescription, title, launchYear);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(genre, other.genre) && id == other.id && Objects.equals(imgUrl, other.imgUrl)
				&& Objects.equals(longDescription, other.longDescription) && Objects.equals(platforms, other.platforms)
				&& Objects.equals(score, other.score) && Objects.equals(shortDescription, other.shortDescription)
				&& Objects.equals(title, other.title) && Objects.equals(launchYear, other.launchYear);
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Integer getLaunchYear() {
		return launchYear;
	}



	public void setLaunchYear(Integer launchYear) {
		this.launchYear = launchYear;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getPlatforms() {
		return platforms;
	}



	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}



	public Double getScore() {
		return score;
	}



	public void setScore(Double score) {
		this.score = score;
	}



	public String getImgUrl() {
		return imgUrl;
	}



	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



	public String getShortDescription() {
		return shortDescription;
	}



	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}



	public String getLongDescription() {
		return longDescription;
	}



	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}



	public long getId() {
		return id;
	}
	
	

}
