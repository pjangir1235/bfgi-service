package com.bfgi.bean.response.DTO;

public class PaymentResponseDto {
    private Long targetUserId;
    private Long sourceUserId;
    private Double amount;
    private Double balance;
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
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
    
    
    

}
