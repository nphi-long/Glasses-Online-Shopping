package sof302.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private String name;
    private String type;
    private Float price;
    private Integer quantity;
    private String image;
    private String description;
    @ManyToMany(cascade = CascadeType.ALL,
            mappedBy = "products")
    Collection<Bill> bills;
}
