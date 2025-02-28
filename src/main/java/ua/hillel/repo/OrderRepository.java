package ua.hillel.repo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.hillel.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class OrderRepository {
    private List<Order> orders;
    private final AtomicInteger counter;

    public OrderRepository() {
        orders = new ArrayList<>();
        counter = new AtomicInteger(0);
    }

    public Optional<Order> findById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst();
    }

    public List<Order> findAll() {
        return orders;
    }

    public Order save(Order order) {
        order.setId(counter.incrementAndGet());
        orders.add(order);
        return order;
    }
}
