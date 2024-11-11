package com.algoriant.order;

import com.algoriant.order.controller.OrderController;
import com.algoriant.order.model.Order;
import com.algoriant.order.model.OrderDTO;
import com.algoriant.order.model.OrderRequest;
import com.algoriant.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
public class OrderControllerTest {

    @Mock
    private OrderService orderService;
    @InjectMocks
    OrderController orderController;
    @Test
    public void saveOrder(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setItemIds(1);
            order.setTotalAmount(2000.00);
//            when(orderService.createOrder(OrderRequest.toDto(order))).thenReturn(order);
//            ResponseEntity<Order> orderResponseEntity = orderController.createOrder(OrderRequest.toDto(order));
//            assertEquals(HttpStatus.CREATED,orderResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing saveOrder method",th);
        }
    }
    @Test
    public void findOrderById(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            when(orderService.getOrder(order.getOrderId())).thenReturn(OrderDTO.toDTO(order));
            ResponseEntity<OrderDTO> orderDTOResponseEntity = orderController.getOrder(order.getOrderId());
            assertEquals(HttpStatus.OK,orderDTOResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing findOrderById method",th);
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
            orderService.createOrder(OrderRequest.toDto(order));
            Order order1 = new Order();
            order1.setOrderDate(new Date());
            order1.setCustomerId(1);
//            order1.setProductId(1);
            order1.setTotalAmount(3000.00);
            orderService.createOrder(OrderRequest.toDto(order));
            List<Order> list = new ArrayList<>();
            list.add(order);
            list.add(order1);
            when(orderService.getAllOrder()).thenReturn(OrderDTO.toListDTO(list));
            ResponseEntity<List<OrderDTO>> listResponseEntity = orderController.getAllOrder();
            assertEquals(HttpStatus.OK,listResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getAllOrder method",th);
        }
    }
    @Test
    public void deleteOrderTest(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            orderService.createOrder(OrderRequest.toDto(order));
            orderService.removeOrder(order.getOrderId());
            ResponseEntity<String> stringResponseEntity = orderController.removeOrder(order.getOrderId());
            assertEquals(HttpStatus.OK,stringResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing deleteOrderTest method",th);
        }
    }
    @Test
    public void modifyOrderTest(){
        try{
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setCustomerId(1);
//            order.setProductId(1);
            order.setTotalAmount(2000.00);
            OrderRequest orderRequest = OrderRequest.toDto(order);
            when(orderService.modifyOrder(order.getOrderId(),orderRequest)).thenReturn(order);
            ResponseEntity<Order> orderResponseEntity = orderController.modifyOrder(order.getOrderId(),orderRequest);
            assertEquals(HttpStatus.OK,orderResponseEntity.getStatusCode());

        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing modifyOrderTest method",th);
        }
    }
}
