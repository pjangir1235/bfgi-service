package com.bfgi.bean.dto;

import java.util.Date;

public class TransactionDTO {
	
	private Long sourceUserId;
	private Long targetUserId;
	private Date date;
	private Double amount;
	private String status;


	public Long getSourceUserId() {
		return sourceUserId;
	}

	public void setSourceUserId(Long sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	public Long getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(Long targetUserId) {
		this.targetUserId = targetUserId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
