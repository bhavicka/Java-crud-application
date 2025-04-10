package com.bhavika.crudapplication.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserMapper {

    //for input
    public User toUser(UserDto userDto){
        if(userDto == null)
            throw new NullPointerException("UserDto object is null");
        User users = new User();
        users.setFirstName(userDto.firstName());
        users.setLastName(userDto.lastName());
        users.setUserName(userDto.userName());
        users.setEmail(userDto.email());
        int pswd = Math.abs(userDto.password().hashCode()*userDto.firstName().hashCode()*userDto.lastName().hashCode());
        users.setPassword(String.valueOf(pswd));
        users.setRole(userDto.role());
        users.setBirthDate(userDto.birthDate());
        return users;
    }

//    for output
    public UserResponseDto toUserResponseDto(User user){
        return new UserResponseDto(
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getRole(),
                user.getBirthDate()
        );
    }

//    for bulk output
    public List<ResponseEntity<UserResponseDto>> toUserResponseDtoList(List<User> users){
        return  users
                .stream()
                .map(this::toUserResponseDto)
                .toList()
                .stream()
                .map(ResponseEntity::ok)
                .toList();
    }
}
