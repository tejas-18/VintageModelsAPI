package com.classicmodels.classicmodelsservice.serviceImpl;

import java.util.List;

import com.classicmodels.classicmodelsservice.entity.Customer;
import com.classicmodels.classicmodelsservice.entity.OrderDetail;
import com.classicmodels.classicmodelsservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classicmodels.classicmodelsservice.entity.Order;
import com.classicmodels.classicmodelsservice.repository.OrderRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;  // Corrected repository variable

    @Autowired
    private RestTemplate restTemplate;

    // URL for Customer Service (assuming Customer Service runs on port 8081)
    private final String CUSTOMER_SERVICE_URL = "http://localhost:8080/api/customers/";
    private final String ORDER_DETAILS_SERVICE_URL = "http://localhost:8080/api/order-details/";



    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

//    @Override
//    public Order findById(Long id) {
//        return orderRepository.findById(id).orElse(null);
//    }

    @Override
    public Order findById(Long orderId) {
        // Find the order by ID
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return null;
        }

        // Fetch customer information from Customer Service using customerNumber
        Long customerNumber = order.getCustomerNumber();
        Customer customer = restTemplate.getForObject(
                CUSTOMER_SERVICE_URL + customerNumber, Customer.class);

        // Set the retrieved customer information in the order
        order.setCustomer(customer);

        return order;
    }


    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

}