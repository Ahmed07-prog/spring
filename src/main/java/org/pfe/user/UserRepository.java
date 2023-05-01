package org.pfe.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
  @Query("SELECT u FROM User u ")
  List<User> findAllUsers();
  Optional<User> findByEmail(String email);
  User findUserByEmail(String email);
  Boolean existsByEmail(String email);
  User findByResetPasswordToken(String token);
  User findUserById(Long id);
  Boolean existsByUsername(String username);

  User findByUsername(String username);
  Boolean existsByCin(int cin);

  Boolean existsByPhone(int phone);

}
