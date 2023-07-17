package com.barnaclaebit.project.entity.dto;

import java.util.Objects;

import com.barnaclaebit.project.entity.Game;

public class GameDTO {

	private long id;
	private String title;
	private Integer launchYear;
	private String imgUrl;
	private String shortDescription;

	public GameDTO() {

	}

	public GameDTO(long id, String title, Integer launchYear, String imgUrl, String shortDescription) {
		super();
		this.id = id;
		this.title = title;
		this.launchYear = launchYear;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
	}

	public GameDTO(Game entity) {
		super();
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.launchYear = entity.getLaunchYear();
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, imgUrl, launchYear, shortDescription, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameDTO other = (GameDTO) obj;
		return id == other.id && Objects.equals(imgUrl, other.imgUrl) && Objects.equals(launchYear, other.launchYear)
				&& Objects.equals(shortDescription, other.shortDescription) && Objects.equals(title, other.title);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}
