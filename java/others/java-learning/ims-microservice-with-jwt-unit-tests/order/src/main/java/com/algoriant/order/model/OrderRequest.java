package com.algoriant.order.model;

import java.util.Date;
import java.util.List;

public class OrderRequest {

    private Date orderDate;
    private double totalAmount;
    private int customerId;
    private List<String> itemIds;
    private List<Integer> quantity;

    public List<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }

    public static OrderRequest toDto(Order order){
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderDate(order.getOrderDate());
        orderRequest.setCustomerId(order.getCustomerId());
        orderRequest.setItemIds(order.getItemIds());
        orderRequest.setTotalAmount(order.getTotalAmount());
        orderRequest.setQuantity(order.getQuantity());
        return orderRequest;

    }

}
