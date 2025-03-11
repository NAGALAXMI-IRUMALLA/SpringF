package com.project.flight_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Airhostess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airhostessId;
	private String airhostessName;
	private double airhostessSalary;
	private int airhostessAge;
	private long airhostessPhone;
	public int getAirhostessId() {
		return airhostessId;
	}
	public void setAirhostessId(int airhostessId) {
		this.airhostessId = airhostessId;
	}
	public String getAirhostessName() {
		return airhostessName;
	}
	public void setAirhostessName(String airhostessName) {
		this.airhostessName = airhostessName;
	}
	public double getAirhostessSalary() {
		return airhostessSalary;
	}
	public void setAirhostessSalary(double airhostessSalary) {
		this.airhostessSalary = airhostessSalary;
	}
	public int getAirhostessAge() {
		return airhostessAge;
	}
	public void setAirhostessAge(int airhostessAge) {
		this.airhostessAge = airhostessAge;
	}
	public long getAirhostessPhone() {
		return airhostessPhone;
	}
	public void setAirhostessPhone(long airhostessPhone) {
		this.airhostessPhone = airhostessPhone;
	}
	
	

}
