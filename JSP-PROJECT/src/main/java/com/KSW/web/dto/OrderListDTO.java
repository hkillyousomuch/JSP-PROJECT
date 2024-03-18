package com.KSW.web.dto;

import java.text.SimpleDateFormat;

public class OrderListDTO {
	private int orderNum;			//주문내역 번호 PK
	private String orderDate;			//주문 날짜
    private String userId;			//유저 아이디 FK
    private String title;			//책 제목
    private int discount;			//책 가격
    private String deliveryStatus;	//책 배송 상태
    private int count;				//책 수량
	
    public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
    
    
}
