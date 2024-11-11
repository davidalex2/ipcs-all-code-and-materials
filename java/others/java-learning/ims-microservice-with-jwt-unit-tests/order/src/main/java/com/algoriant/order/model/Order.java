package com.algoriant.order.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private int orderId;
    @Column(name = "o_date")
    private Date orderDate;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "c_id")
    private int customerId;
    @Column(name = "i_id")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "itemIdAndQuantity")
    private List<String> itemIds;
    @Column(name = "quantity")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "itemIdAndQuantity")
    private List<Integer> quantity;


    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    }

    public List<Integer> getQuantity() {
        return quantity;
    }

    public int getOrderId() {
        return orderId;
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

    public Order(int orderId, Date orderDate, double totalAmount, int customerId, List<String> itemIds, List<Integer> quantity) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
        this.itemIds = itemIds;
        this.quantity = quantity;
    }

    public Order() {
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

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", customerId=" + customerId +
                ", itemIds=" + itemIds +
                ", quantity=" + quantity +
                '}';
    }

    public static Order toEntity(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderDate(orderRequest.getOrderDate());
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setCustomerId(orderRequest.getCustomerId());
        order.setItemIds(orderRequest.getItemIds());
        order.setQuantity(orderRequest.getQuantity());
        order.setQuantity(orderRequest.getQuantity());
        return order;
    }
}
