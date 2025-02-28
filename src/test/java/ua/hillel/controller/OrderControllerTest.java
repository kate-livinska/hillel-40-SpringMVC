package ua.hillel.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.hillel.model.Order;
import ua.hillel.model.Product;
import ua.hillel.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)  // For Mockito support
@ExtendWith(SpringExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order(1, new Date(), 150.75, List.of(new Product(101, "Laptop", 1200.00)));
    }

    @Test
    void findByIdTest_returnsOrder() {
        int id = 1;
        when(orderService.findById(id)).thenReturn(Optional.of(order));

        ResponseEntity<Order> response = orderController.findById(id);

        assertNotNull(response);
        assertEquals(order, response.getBody());
    }

    @Test
    void findByIdTest_noIdReturnsNotFound() {
        int id = 100;
        when(orderService.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Order> response = orderController.findById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }


    @Test
    void findAllTest_returnsOrders() {
        List<Order> orders = List.of(order);
        when(orderService.findAll()).thenReturn(orders);

        ResponseEntity<List<Order>> response = orderController.findAllOrders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }

    @Test
    void saveTest_returnsOrder() {
        Order testOrder = new Order(2, new Date(), 250.75, List.of(new Product(102, "Phone", 2200.00)));
        when(orderService.save(any(Order.class))).thenReturn(testOrder);

        ResponseEntity<Order> response = orderController.createOrder(testOrder);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}