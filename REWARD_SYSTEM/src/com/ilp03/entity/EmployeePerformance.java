package com.ilp03.entity;

import java.sql.Date; 

public class EmployeePerformance {

    private int performanceId;
    private int employeeId;
    private Date performanceDate;
    private int reviewerId;
    private int technicalRating;
    private int behaviouralRating;

    public EmployeePerformance(int performanceId, int employeeId, Date performanceDate,
                                int reviewerId, int technicalRating, int behaviouralRating) {
        this.performanceId = performanceId;
        this.employeeId = employeeId;
        this.performanceDate = performanceDate;
        this.reviewerId = reviewerId;
        this.technicalRating = technicalRating;
        this.behaviouralRating = behaviouralRating;
    }

	public int getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(int performanceId) {
		this.performanceId = performanceId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getPerformanceDate() {
		return performanceDate;
	}

	public void setPerformanceDate(Date performanceDate) {
		this.performanceDate = performanceDate;
	}

	public int getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
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

}
