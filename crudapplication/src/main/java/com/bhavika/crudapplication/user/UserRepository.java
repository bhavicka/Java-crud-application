package com.bhavika.crudapplication.user;

import jakarta.validation.constraints.PastOrPresent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

//for JPA queries
public interface UserRepository extends JpaRepository<User, Integer> {
    Object findUserById(Integer id);

    List<User> findUsersByFirstName(String firstName);

    List<User> findUsersByRole(String role);

    List<User> findUsersByEmailLike(String email);

    List<User> findUsersByUserName(String firstName);

    List<User> findByUserCreatedAfter(@PastOrPresent LocalDate userCreated);

    List<User> findAllByOrderByBirthDate();
}
