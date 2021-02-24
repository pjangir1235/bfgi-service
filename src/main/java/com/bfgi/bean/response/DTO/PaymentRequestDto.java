package com.bfgi.bean.response.DTO;

public class PaymentRequestDto {
    private Long targetUserId;
    private Long sourceUserId;
    private Double amount;
	public Long getTargetUserId() {
		return targetUserId;
	}
	public void setTargetUserId(Long targetUserId) {
		this.targetUserId = targetUserId;
	}
	public Long getSourceUserId() {
		return sourceUserId;
	}
	public void setSourceUserId(Long sourceUserId) {
		this.sourceUserId = sourceUserId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
    
    
    

}
