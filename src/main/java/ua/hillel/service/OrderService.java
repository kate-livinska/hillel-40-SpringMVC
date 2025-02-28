package ua.hillel.service;

import ua.hillel.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(int id);
    Order save(Order order);
}
