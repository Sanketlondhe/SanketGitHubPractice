package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // room number (roomNo in your diagram)
    @Column(name = "room_no")
    private String roomNo;

    // how many sharing (2,3 etc.)
    @Column(name = "sharing")
    private Integer sharing;

    @Column(name = "type")
    private String type;

    // Many rooms -> one floor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", nullable = false)
    private Floors floor;

    // One room -> many beds
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Bed> beds = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Integer getSharing() {
		return sharing;
	}

	public void setSharing(Integer sharing) {
		this.sharing = sharing;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Floors getFloor() {
		return floor;
	}

	public void setFloor(Floors floor) {
		this.floor = floor;
	}

	public List<Bed> getBeds() {
		return beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}
    
    

}
