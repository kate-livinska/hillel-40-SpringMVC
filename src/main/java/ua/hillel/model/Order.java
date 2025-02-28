package ua.hillel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Order {
    private int id;
    private Date creationDate;
    private double totalCost;
    private List<Product> products;
}
