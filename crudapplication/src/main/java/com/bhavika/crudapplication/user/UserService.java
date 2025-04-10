package com.bhavika.crudapplication.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
//Business Logic
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public ResponseEntity<UserResponseDto> saveUser(
            UserDto userDto
    ) {
        var user = userMapper.toUser(userDto);
        UserResponseDto entity = userMapper.toUserResponseDto(userRepository.save(user));
        return ResponseEntity.ok(entity);
    }

    public List<ResponseEntity<UserResponseDto>> saveUsers(
            List<UserDto> userDtoList
    ) {
        List<User> users = userDtoList
                .stream()
                .map(userMapper::toUser)
                .toList();
        userRepository.saveAll(users);
        return userMapper.toUserResponseDtoList(users);
    }

    public List<ResponseEntity<UserResponseDto>> getAllUsers() {
        return userMapper.toUserResponseDtoList(userRepository.findAll());
    }


    public ResponseEntity<UserResponseDto> getUserById(
            Integer id
    ) {
        User user = (User) userRepository.findUserById(id);
        var userResponseDto = userMapper.toUserResponseDto(user);
        return ResponseEntity.ok(userResponseDto);
    }

    public List<ResponseEntity<UserResponseDto>> getUsersByUserName(
            String firstName
    ) {
        List<User> users = userRepository.findUsersByUserName(firstName);
        return userMapper.toUserResponseDtoList(users);
    }

    public List<ResponseEntity<UserResponseDto>> getUsersByRole(
            String role
    ) {
        List<User> users = userRepository.findUsersByRole(role);
        return userMapper.toUserResponseDtoList(users);
    }

    public List<ResponseEntity<UserResponseDto>> getUsersByMailDomainLike(
            String email
    ) {
        List<User> users = userRepository.findUsersByEmailLike("%@" + email + "%");
        return userMapper.toUserResponseDtoList(users);
    }

    public List<ResponseEntity<UserResponseDto>> getUsersCreatedInLastThirtyDays() {
        LocalDate today = LocalDate.now();
        LocalDate aMonthBack = today.minusDays(30);
        List<User> users = userRepository.findByUserCreatedAfter(aMonthBack);
        return userMapper.toUserResponseDtoList(users);
    }

    public List<ResponseEntity<UserResponseDto>> getUsersSortedByBirthDate() {
        List<User> users = userRepository.findAllByOrderByBirthDate();
        return userMapper.toUserResponseDtoList(users);
    }

    public long getCountOfUsers(){
        return userRepository.count();
    }
}
