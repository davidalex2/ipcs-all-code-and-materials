package com.algoriant.order;


import com.algoriant.order.model.Order;
import com.algoriant.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Test
    public void saveOrder(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            Order order1 = orderRepository.save(order);
            assertThat(order1).isNotNull();
            assertThat(order1.getOrderId()).isGreaterThan(0);
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing saveOrder method",th);
        }
    }
    @Test
    public void getAllOrder(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            orderRepository.save(order);
            Order order1 = new Order();
            order1.setOrderDate(new Date());
            order1.setCustomerId(2);
//            order1.setProductId(2);
            order1.setTotalAmount(4000.00);
            orderRepository.save(order);
            List<Order> orderList = (List<Order>) orderRepository.findAll();
            assertThat(orderList).isNotNull();
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getAllOrder method",th);
        }
    }
    @Test
    public void getOrderById(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            orderRepository.save(order);
            Order order1 = orderRepository.findById(order.getOrderId()).get();
            assertThat(order1).isNotNull();
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getOrderById method",th);
        }
    }
    @Test
    public void deleteOrder(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            orderRepository.save(order);
            orderRepository.deleteById(order.getOrderId());
            Optional<Order> optionalOrder = orderRepository.findById(order.getOrderId());
            assertThat(optionalOrder).isEmpty();
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing deleteOrder method",th);
        }
    }
}
