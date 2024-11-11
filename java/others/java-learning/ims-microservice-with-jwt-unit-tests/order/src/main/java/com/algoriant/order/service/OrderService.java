package com.algoriant.order.service;

import com.algoriant.order.model.Order;
import com.algoriant.order.model.OrderRequest;
import com.algoriant.order.model.OrderDTO;
import com.algoriant.order.model.Product;
import com.algoriant.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired private RestTemplate template;
    private final static String URL_CUSTOMER = "http://localhost:8765/customer-service/customer/sendCustomerById/";
    private final static String URL_PRODUCT_GET = "http://localhost:8765/product-service/product/sendProductbyid/";
    private final static String URL_PRODUCT_PUT_QUANTITY = "http://localhost:8765/product-service/product/changeQuantity/";
    private final static String URL_PRODUCT_UPDATE_QUANTITY = "http://localhost:8765/product-service/product/updateQuantity/";


    public Order createOrder(OrderRequest orderRequest) {
        RestTemplate restTemplate = new RestTemplate();
        List<String> base64EncodedIds = orderRequest.getItemIds();

        List<Integer> productIds = new ArrayList<>();
        for (String base64Encode:base64EncodedIds){
            String itemids = base64Decode(base64Encode);
            String[] splitString =itemids.split("_");
            int productId = Integer.parseInt(splitString[0]);

            productIds.add(productId);
        }

        List<Integer> quantityList = orderRequest.getQuantity();
        for (int i=0;i<quantityList.size();i++){
            restTemplate.put(URL_PRODUCT_PUT_QUANTITY + productIds.get(i) + "/" + quantityList.get(i), Product.class);
        }

        return orderRepository.save(Order.toEntity(orderRequest));
    }

    public Order modifyOrder(int id, OrderRequest orderRequest) {

        Order order = new Order();
        Optional<OrderDTO> optionalOrderDTO = Optional.of(OrderDTO.toDTO(orderRepository.findById(id).get()));
        if (optionalOrderDTO.isPresent()){
            order.setOrderId(id);
            order.setOrderDate(orderRequest.getOrderDate());
            order.setTotalAmount(orderRequest.getTotalAmount());
            order.setCustomerId(orderRequest.getCustomerId());
            order.setQuantity(orderRequest.getQuantity());
            orderRepository.save(order);
        }
        return order;
    }

    public void removeOrder(int id) {
        Optional<OrderDTO> optionalOrderDTO = Optional.of(OrderDTO.toDTO(orderRepository.findById(id).get()));
        OrderDTO orderDTO = optionalOrderDTO.get();
        RestTemplate restTemplate = new RestTemplate();
        List<String> base64EncodedIds = orderDTO.getItemIds();

        List<Integer> productIds = new ArrayList<>();

        for (String base64Encode:base64EncodedIds){
            String itemids = base64Decode(base64Encode);
            String[] splitString =itemids.split("_");
            int productId = Integer.parseInt(splitString[0]);

            productIds.add(productId);
        }

        List<Integer> quantityList = orderDTO.getQuantity();
        for (int i=0;i<quantityList.size();i++){
            restTemplate.put(URL_PRODUCT_UPDATE_QUANTITY + productIds.get(i) + "/" + quantityList.get(i), Product.class);
        }
        orderRepository.deleteById(id);
    }

    public OrderDTO getOrder(int id) {
        Optional<OrderDTO> optionalOrderDTO = Optional.of(OrderDTO.toDTO(orderRepository.findById(id).get()));
        if (optionalOrderDTO.isPresent()) {
            return optionalOrderDTO.get();
        }
        return null;
    }

    public List<OrderDTO> getAllOrder() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return OrderDTO.toListDTO(orders);
    }

    public static String base64Decode(String base64EncodedData) {
        byte[] base64EncodedBytes = Base64.getDecoder().decode(base64EncodedData);
        return new String(base64EncodedBytes);
    }
}
