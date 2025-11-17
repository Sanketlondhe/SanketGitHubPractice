package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hostels {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private int capacity;
	private long contactNo;
	private String type;
	private String Website;
	
	 // One hostel -> many buildings
    @OneToMany(mappedBy = "hostel", cascade = CascadeType.ALL)
    private List<Building> buildings = new ArrayList<>();
    
	
	public List<Building> getBuildings() {
		return buildings;
	}
	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWebsite() {
		return Website;
	}
	public void setWebsite(String website) {
		Website = website;
	}
	@Override
	public String toString() {
		return "Hostels [id=" + id + ", name=" + name + ", address=" + address + ", capacity=" + capacity
				+ ", contactNo=" + contactNo + ", type=" + type + ", Website=" + Website + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getAddress()=" + getAddress() + ", getCapacity()=" + getCapacity()
				+ ", getContactNo()=" + getContactNo() + ", getType()=" + getType() + ", getWebsite()=" + getWebsite()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Website, address, capacity, contactNo, id, name, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hostels other = (Hostels) obj;
		return Objects.equals(Website, other.Website) && Objects.equals(address, other.address)
				&& capacity == other.capacity && contactNo == other.contactNo && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}
	
	
}
