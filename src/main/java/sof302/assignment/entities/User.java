package sof302.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column(unique = true)
    private String username;
    private String password;
    private transient String repeatpassword;
    private String role;
    private String name;
    private String phone;
    private String address;
    private String gender;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<Bill> bills;
}
