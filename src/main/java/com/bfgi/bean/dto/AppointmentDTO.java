package com.bfgi.bean.dto;

import java.util.Date;

public class AppointmentDTO {
    /**
     *
     */
    private int id;
    private int userId;
    private Date date;
    private String reason;
    private boolean isAddressSame;
    private String presentAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isAddressSame() {
        return isAddressSame;
    }

    public void setAddressSame(boolean addressSame) {
        isAddressSame = addressSame;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }
}
