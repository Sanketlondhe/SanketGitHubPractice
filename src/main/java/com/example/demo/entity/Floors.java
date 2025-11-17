package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Floors {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "floor_no")
    private Integer floorNo;

    @Column(name = "no_rooms")
    private Integer noRooms;

    // Many floors -> one building
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    // One floor -> many rooms
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(Integer floorNo) {
		this.floorNo = floorNo;
	}

	public Integer getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(Integer noRooms) {
		this.noRooms = noRooms;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	} 
    
    
    

}
