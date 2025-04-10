package com.bhavika.crudapplication.address;

import com.bhavika.crudapplication.BaseEntity;
//import com.bhavika.crudapplication.order.Order;
import com.bhavika.crudapplication.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
public class Address extends BaseEntity {
//    @ManyToMany(mappedBy = "address")
//    private List<User> users;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
//    @OneToMany(mappedBy = "address_id")
//    private List<Order> orderList;
}
