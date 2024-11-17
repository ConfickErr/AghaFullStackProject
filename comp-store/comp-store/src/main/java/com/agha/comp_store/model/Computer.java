package com.agha.comp_store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Computer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "producer_id")
	private Producer producer;
	private String state;
	private Double price;
	private String descrition;
	private Integer ram;
	
	@ManyToOne
	@JoinColumn(name = "cpu_id")
	private CPU cpu;
	private Integer rom;
	private String romType;
	
	@ManyToOne
	@JoinColumn(name = "os_id")
	private OS os;
	
	@ManyToOne
	@JoinColumn(name = "gpu_id")
	private GPU gpu;
	private String imgURL;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
}
