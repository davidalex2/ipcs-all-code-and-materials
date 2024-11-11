package com.algoriant.order.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDTO {

    private int orderId;
    private Date orderDate;
    private double totalAmount;
    private List<String> itemIds;
    private List<Integer> quantity;
    private int customerId;

    public List<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public static OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotalAmount(order.getTotalAmount());
        orderDTO.setCustomerId(order.getCustomerId());
        orderDTO.setItemIds(order.getItemIds());
        orderDTO.setQuantity(order.getQuantity());
        return orderDTO;
    }

    public static List<OrderDTO> toListDTO(List<Order> orders) {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(order.getOrderId());
            orderDTO.setOrderDate(order.getOrderDate());
            orderDTO.setTotalAmount(order.getTotalAmount());
            orderDTO.setCustomerId(order.getCustomerId());
            orderDTO.setItemIds(order.getItemIds());
            orderDTO.setQuantity(order.getQuantity());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }
}
