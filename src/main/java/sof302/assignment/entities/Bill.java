package sof302.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid")
    private User user;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private String status;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "billdetails",
            joinColumns = @JoinColumn(name = "bid"),
            inverseJoinColumns = @JoinColumn(name = "pid"))
    Collection<Product> products;
}
