package com.lipengchao.parking.entity;

import java.util.Date;

public class ParkingInfo {
    private Long id;

    private Long carId;

    private Long carportId;

    private Date arriveTime;

    private Date leaveTime;

    private Long duration;

    private Long expense;

    private Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCarportId() {
        return carportId;
    }

    public void setCarportId(Long carportId) {
        this.carportId = carportId;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getExpense() {
        return expense;
    }

    public void setExpense(Long expense) {
        this.expense = expense;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}