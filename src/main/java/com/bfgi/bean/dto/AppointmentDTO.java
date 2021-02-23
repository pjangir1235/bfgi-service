package com.bfgi.bean.dto;

import java.sql.Time;
import java.util.Date;

public class AppointmentDTO {
    private Long userId;
    private Date date;
    private Time time;
    private String reason;
    private Boolean isAddressSame;
    private String presentAddress;

    public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Boolean getIsAddressSame() {
		return isAddressSame;
	}
	public void setIsAddressSame(Boolean isAddressSame) {
		this.isAddressSame = isAddressSame;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

}
