package com.marvel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class MarvelCharacter {
	@Id
	@Column(name="id")
	long id;
	@Column(name="name")
	String name;
	@Column(name="description")
	String description;
	//@Column(name="modified_date")
	//Date modifiedDate;
	@Column(name="img")
	String image;
	
	public MarvelCharacter() {
		super();
	}
	public MarvelCharacter(long id, String name, String description, String image) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//this.modifiedDate = modifiedDate;
		this.image = image;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	/*public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}*/
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	

}
