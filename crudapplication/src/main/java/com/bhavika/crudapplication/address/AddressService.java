package com.bhavika.crudapplication.address;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService {
    AddressMapper addressMapper;
    AddressRepository addressRepository;
    AddressService(AddressMapper addressMapper, AddressRepository addressRepository){
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    public ResponseEntity<Address> save(Address dto){
//        Address a = addressMapper.toAddress(dto);
        return ResponseEntity.ok(addressRepository.save(dto));
    }

    public ResponseEntity<List<Address>> getAll(){
        List<Address> addressList = addressRepository.findAll();
        return ResponseEntity.ok(addressList);
    }

    public ResponseEntity<List<Address>> getByCity(String city){
        List<Address> addressList = addressRepository.findByCity(city);
        return ResponseEntity.ok(addressList);
    }

    public ResponseEntity<List<Address>> getByState(String state){
        List<Address> addressList = addressRepository.findByState(state);
        return ResponseEntity.ok(addressList);
    }

    public ResponseEntity<List<Address>> getByCountry(String country){
        List<Address> addressList = addressRepository.findByCountry(country);
        return ResponseEntity.ok(addressList);
    }

    public ResponseEntity<List<Address>> getByPincode(String pincode){
        List<Address> addressList = addressRepository.findByPincode(pincode);
        return ResponseEntity.ok(addressList);
    }
}
