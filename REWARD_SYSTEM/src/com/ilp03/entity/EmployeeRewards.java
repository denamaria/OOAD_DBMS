package com.ilp03.entity;

import java.util.Date;

public class EmployeeRewards 
{
	private int employeeRewardId;
    private int rewardId;
    private Date dateReceived;
    private int performanceId;

    public EmployeeRewards(int employeeRewardId, int rewardId, Date dateReceived, int performanceId) {
        this.employeeRewardId = employeeRewardId;
        this.rewardId = rewardId;
        this.dateReceived = dateReceived;
        this.performanceId = performanceId;

}

	public int getEmployeeRewardId() {
		return employeeRewardId;
	}

	public void setEmployeeRewardId(int employeeRewardId) {
		this.employeeRewardId = employeeRewardId;
	}

	public int getRewardId() {
		return rewardId;
	}

	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public int getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(int performanceId) {
		this.performanceId = performanceId;
	}
    
}