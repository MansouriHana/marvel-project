package com.marvel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="character")
public class Character {
	@Id
	@Column(name="id")
	int id;
	@Column(name="name")
	String name;
	@Column(name="description")
	String description;
	@Column(name="modified_date")
	Date modifiedDate;
	@Column(name="image")
	String image;
	
	public Character() {
		super();
	}
	public Character(int id, String name, String description, Date modifiedDate, String image) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.modifiedDate = modifiedDate;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	

}
