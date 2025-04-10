package com.bhavika.crudapplication.address;

import java.util.Arrays;
import java.util.List;

public record AddressDto(
//        List<Integer> users,
        String address,
        String city,
        String state,
        String country,
        String pincode
//        List<Integer> orderList
)
{
}
