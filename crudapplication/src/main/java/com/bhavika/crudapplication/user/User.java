package com.bhavika.crudapplication.user;

import com.bhavika.crudapplication.BaseEntity;
import com.bhavika.crudapplication.address.Address;
//import com.bhavika.crudapplication.order.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Table(name = "Users")
public class User extends BaseEntity {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @Column(
            nullable = false,
            unique = true
    )
    @JsonProperty("userName")
    private String userName;

    @Column(unique = true, nullable = false)
    @JsonProperty("email")
    @Email
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    @Column(nullable = false)
    private String role;

    @JsonProperty("birthDate")
    @Column(nullable = false)
    @Past
    private LocalDate birthDate;

    @Column(updatable = false, nullable = false)
    @PastOrPresent
    private LocalDate userCreated;

//    @ManyToMany
//    @JoinTable(
//            name = "user_address",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "address_id")
//    )
//    private List<Address> address;

//    @OneToMany(mappedBy = "customer_id")
//    private ArrayList<Integer> order_id;

    @PrePersist
    protected void onCreate() {
        userCreated = LocalDate.now();
    }
}