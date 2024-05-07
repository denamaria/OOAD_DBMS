package com.ilp03.entity;

public class Rewards 
{
	 private int id;
	 private int technicalRating;
	 private int behaviouralRating;
	 private String performance;
	public Rewards(int id, int technicalRating, int behaviouralRating, String performance) {
		//super();
		this.id = id;
		this.technicalRating = technicalRating;
		this.behaviouralRating = behaviouralRating;
		this.performance = performance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTechnicalRating() {
		return technicalRating;
	}
	public void setTechnicalRating(int technicalRating) {
		this.technicalRating = technicalRating;
	}
	public int getBehaviouralRating() {
		return behaviouralRating;
	}
	public void setBehaviouralRating(int behaviouralRating) {
		this.behaviouralRating = behaviouralRating;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	 
}
