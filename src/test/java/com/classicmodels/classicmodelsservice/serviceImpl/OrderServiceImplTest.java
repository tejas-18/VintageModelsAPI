package com.classicmodels.classicmodelsservice.serviceImpl;

import com.classicmodels.classicmodelsservice.entity.Customer;
import com.classicmodels.classicmodelsservice.entity.Order;
import com.classicmodels.classicmodelsservice.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    private final String CUSTOMER_SERVICE_URL = "http://localhost:8080/api/customers/";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById_OrderExists() {
        Long orderId = 103L;

        Order order = new Order();
        order.setOrderNumber(orderId);
        order.setCustomerNumber(1L);

        Customer customer = new Customer();
        customer.setCustomerNumber(1);
        customer.setCustomerName("John Doe");

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
        when(restTemplate.getForObject(CUSTOMER_SERVICE_URL + "1", Customer.class)).thenReturn(customer);

        Order result = orderServiceImpl.findById(orderId);

        assertEquals(103L, result.getOrderNumber());
        assertEquals("John Doe", result.getCustomer().getCustomerName());
    }

    @Test
    void testFindById_OrderDoesNotExist() {
        Long orderId = 999L;

        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        Order result = orderServiceImpl.findById(orderId);

        assertNull(result);
    }

    @Test
    void testSaveOrder() {
        Order order = new Order();
        order.setOrderNumber(105L);

        when(orderRepository.save(order)).thenReturn(order);

        Order savedOrder = orderServiceImpl.save(order);

        assertEquals(105L, savedOrder.getOrderNumber());
    }

    @Test
    void testDeleteOrderById() {
        Long orderId = 105L;
        orderServiceImpl.deleteById(orderId);
        // No result to assert; just checking that delete operation runs without exception
    }
}
