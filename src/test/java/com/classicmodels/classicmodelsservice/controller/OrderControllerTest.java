package com.classicmodels.classicmodelsservice.controller;

import com.classicmodels.classicmodelsservice.entity.Order;
import com.classicmodels.classicmodelsservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    public OrderControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void testFindAllOrders() throws Exception {
        Order order1 = new Order();
        order1.setOrderNumber(101L);

        Order order2 = new Order();
        order2.setOrderNumber(102L);

        List<Order> orders = Arrays.asList(order1, order2);
        when(orderService.findAll()).thenReturn(orders);

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    void testFindOrderById() throws Exception {
        Order order = new Order();
        order.setOrderNumber(103L);

        when(orderService.findById(103L)).thenReturn(order);

        mockMvc.perform(get("/api/orders/103"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderNumber").value(103));
    }

    @Test
    void testSaveOrder() throws Exception {
        Order order = new Order();
        order.setOrderNumber(104L);

        when(orderService.save(order)).thenReturn(order);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderNumber\":104}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderNumber").value(104));
    }

    @Test
    void testDeleteOrderById() throws Exception {
        mockMvc.perform(delete("/api/orders/104"))
                .andExpect(status().isOk());
    }
}
