package com.bhavika.crudapplication.address;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {
    private final AddressService addressService;
    AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    @PostMapping("/Address")
    public ResponseEntity<Address> save(
            @Valid @RequestBody Address dto
    ){
        return addressService.save(dto);
    }

    @GetMapping("/Address")
    public ResponseEntity<List<Address>> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/Address/City/{city}")
    public ResponseEntity<List<Address>> getByCity(
            @PathVariable String city
    ){
        return addressService.getByCity(city);
    }

    @GetMapping("/Address/State/{state}")
    public ResponseEntity<List<Address>> getByState(
            @PathVariable String state
    ){
        return addressService.getByState(state);
    }

    @GetMapping("/Address/Country/{country}")
    public ResponseEntity<List<Address>> getByCountry(
            @PathVariable String country
    ){
        return addressService.getByCountry(country);
    }

    @GetMapping("/Address/Pincode/{pincode}")
    public ResponseEntity<List<Address>> getByPincode(
            @PathVariable String pincode
    ){
        return addressService.getByPincode(pincode);
    }
}
