package com.bhavika.crudapplication.address;

import com.bhavika.crudapplication.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<User> findByIdIn(List<Integer> ids);

    List<Address> findByCity(String city);

    List<Address> city(String city);

    List<Address> findByState(String state);

    List<Address> findByCountry(String country);

    List<Address> findByPincode(String pincode);
}
