package sof302.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sof302.assignment.entities.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Product product;
    private Integer quantity;
}
