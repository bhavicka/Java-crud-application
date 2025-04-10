//package com.bhavika.crudapplication.order;
//
//import com.bhavika.crudapplication.BaseEntity;
//import com.bhavika.crudapplication.address.Address;
//import com.bhavika.crudapplication.user.User;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.PrePersist;
//import jakarta.validation.constraints.Future;
//import jakarta.validation.constraints.PastOrPresent;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import lombok.experimental.SuperBuilder;
//
//import java.time.LocalDateTime;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@SuperBuilder
//@EqualsAndHashCode(callSuper = true)
//@Entity
//public class Order extends BaseEntity {
//    @ManyToOne
//    private User customer_id;
//    private long total_price;
//    private enum Status{PENDING, SHIPPED, DELIVERED, CANCELLED};
//    private Status status;
//
//    @PastOrPresent
//    private LocalDateTime order_date;
//
//    @Future
//    private LocalDateTime delivery_date;
//    private enum PaymentMethod{CARD, UPI, COD};
//    private PaymentMethod paymentMethod;
//
//    @ManyToOne
//    private Address address_id;
//
//    @PrePersist
//    protected void onCreate(){
//        status = Status.PENDING;
//        order_date = LocalDateTime.now();
//    }
//}
