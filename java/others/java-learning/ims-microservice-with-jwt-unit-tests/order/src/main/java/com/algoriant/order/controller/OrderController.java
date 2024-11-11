package com.algoriant.order.controller;

import com.algoriant.order.model.ImsException;
import com.algoriant.order.model.Order;
import com.algoriant.order.model.OrderRequest;
import com.algoriant.order.model.OrderDTO;
import com.algoriant.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) throws ImsException {
        try {
            return new ResponseEntity<>(orderService.createOrder(orderRequest), HttpStatus.CREATED);
        }  catch (Exception e) {
            throw new ImsException("There is a problem please try again after sometime");
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/modifyOrder/{id}")
    public ResponseEntity<Order> modifyOrder(@PathVariable("id") int id, @RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(orderService.modifyOrder(id, orderRequest), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/removeOrder/{id}")
    public ResponseEntity<String> removeOrder(@PathVariable("id") int id) throws ImsException {
        try {
            orderService.removeOrder(id);
            return new ResponseEntity<>("Order removed successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new ImsException("There is a problem please try again after sometime");
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getOrder/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable("id") int id) {
        return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getAllOrder")
    public ResponseEntity<List<OrderDTO>> getAllOrder() {
        List<OrderDTO> orderDTOS = orderService.getAllOrder();
        return new ResponseEntity<>(orderDTOS, HttpStatus.OK);
    }
}
