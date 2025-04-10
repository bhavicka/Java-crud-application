package com.bhavika.crudapplication.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
//bridges the application REST requests
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> postUser(
            @Valid @RequestBody UserDto userDto
    ) {
       return userService.saveUser(userDto);
    }
    @PostMapping("/users")
    public List<ResponseEntity<UserResponseDto>> postUsers(
            @Valid @RequestBody List<UserDto> userDtoList
    ){
        return userService.saveUsers(userDtoList);
    }

    @GetMapping("/users")
    public List<ResponseEntity<UserResponseDto>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDto> getUser(
            @PathVariable Integer id
    ) {
        return userService.getUserById(id);
    }

    @GetMapping("users/{username}")
    public List<ResponseEntity<UserResponseDto>> getUsersByFirstName(
            @PathVariable String username
    ){
        return userService.getUsersByUserName(username);
    }

    @GetMapping("users/role/{role}")
    public List<ResponseEntity<UserResponseDto>> getUsersByRole(
            @PathVariable String role
    ){
        return userService.getUsersByRole(role);
    }

    @GetMapping("users/email/{mail}")
    public List<ResponseEntity<UserResponseDto>> getUsersByMailDomainLike(
            @PathVariable String mail
    ){
        return userService.getUsersByMailDomainLike(mail);
    }

    @GetMapping("users/date/recent")
    public List<ResponseEntity<UserResponseDto>> getUsersCreatedInLastThirtyDays(){
        return userService.getUsersCreatedInLastThirtyDays();
    }

    @GetMapping("users/date/birthdate/asc")
    public List<ResponseEntity<UserResponseDto>> getUsersSortedByBirthDate() {
        return userService.getUsersSortedByBirthDate();
    }

    @GetMapping("users/count")
    public long getCountOfUsers(){
        return userService.getCountOfUsers();
    }
}
