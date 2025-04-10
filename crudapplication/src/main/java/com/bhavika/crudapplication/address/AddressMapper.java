package com.bhavika.crudapplication.address;

import com.bhavika.crudapplication.address.AddressRepository;
import com.bhavika.crudapplication.user.User;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AddressMapper {
//    AddressRepository addressRepository;
//    AddressMapper(AddressRepository r){
//        addressRepository = r;
//    }
    public Address toAddress(AddressDto dto){
//        AddressRepository repository;
        Address address = new Address();
//        int[] loop = new int[dto.users().size()];
//        List<User> usersList = addressRepository.findByIdIn(dto.users());
//        address.setUsers(usersList);
        address.setAddress(dto.address());
        address.setCountry(dto.country());
        address.setCity(dto.city());
        address.setState(dto.state());
        address.setPincode(dto.pincode());
//        address.setUsers(usersList);
        return address;
    }

}
