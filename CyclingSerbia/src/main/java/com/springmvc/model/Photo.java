package com.springmvc.model;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "photos")
public class Photo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "description", nullable = false, length = 255)
	private String description;
	
	@Column(name = "type", nullable = false, length = 100)
	private String type;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name = "content", nullable = false)
	private byte[] content;
		
	//mapping photo to the user
	@ManyToOne( optional = false)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	//Mapping photo to the mountain
	@ManyToOne(optional = false)
	@JoinColumn(name = "mountain_id")
	private Mountain mountain; 
	
	public Mountain getMountain() {
		return mountain;
	}

	public void setMountain(Mountain mountain) {
		this.mountain = mountain;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(content);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mountain == null) ? 0 : mountain.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Photo other = (Photo) obj;
		if (!Arrays.equals(content, other.content))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mountain == null) {
			if (other.mountain != null)
				return false;
		} else if (!mountain.equals(other.mountain))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ", content="
				+ Arrays.toString(content) + ", user=" + user + ", mountain=" + mountain + "]";
	}

	
	
	
}
