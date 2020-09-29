package edu.ing.accountmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ing.accountmanager.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

}
