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
    private String username;
    private String password;
    private transient String repeatpassword;
    private String role;
    private String name;
    private String gender;
    private String phone;
    private String address;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<Bill> bills;
}
