package com.algoriant.order;

import com.algoriant.order.model.Order;
import com.algoriant.order.model.OrderDTO;
import com.algoriant.order.model.OrderRequest;
import com.algoriant.order.repository.OrderRepository;
import com.algoriant.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    OrderService orderService;
    @Test
    public void saveOrder(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            Order order1 = orderRepository.save(order);
            when(orderRepository.save(order1)).thenReturn(order1);
            assertEquals(order1,orderService.createOrder(OrderRequest.toDto(order)));
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing saveOrder method",th);
        }
    }
    @Test
    public void findOrderBYId(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            orderRepository.save(order);
            when(orderRepository.findById(order.getOrderId())).thenReturn(Optional.of(order));
            OrderDTO orderDTO = orderService.getOrder(order.getOrderId());
            assertEquals(order.getOrderId(),orderDTO.getOrderId());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing findOrderBYId method",th);
        }
    }
    @Test
    public void findAllOrder(){
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
            order1.setTotalAmount(2500.00);
            orderRepository.save(order1);
            List<Order> list = new ArrayList<>();
            list.add(order);
            list.add(order1);
            when(orderRepository.findAll()).thenReturn(list);
            assertEquals(list,orderRepository.findAll());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing findAllOrder method",th);
        }
    }
    @Test
    public void deleteOrderById(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            orderRepository.save(order);
            orderService.removeOrder(order.getOrderId());
            verify(orderRepository,times(1)).deleteById(order.getOrderId());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing deleteOrderById method",th);
        }
    }
    @Test
    public void modifyOrder(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            when(orderRepository.findById(order.getOrderId())).thenReturn(Optional.of(order));
            when(orderRepository.save(any())).thenReturn(order);
            Order order1 = orderService.modifyOrder(order.getOrderId(),OrderRequest.toDto(order));
            assertEquals(order.getOrderId(),order1.getOrderId());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing modifyOrder method",th);
        }
    }
}
