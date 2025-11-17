package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Building {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int floors;
	private String name;
	private String warden;
	// Many buildings belong to one hostel
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hostel_id", nullable = false)
    private Hostels hostel;
    
 // One building -> many floors
    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Floors> floorsList = new ArrayList<>();
    
	public List<Floors> getFloorsList() {
		return floorsList;
	}
	public void setFloorsList(List<Floors> floorsList) {
		this.floorsList = floorsList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFloors() {
		return floors;
	}
	public void setFloors(int floors) {
		this.floors = floors;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWarden() {
		return warden;
	}
	public void setWarden(String warden) {
		this.warden = warden;
	}
	public Hostels getHostel() {
		return hostel;
	}
	public void setHostel(Hostels hostel) {
		this.hostel = hostel;
	}
    
    
}
