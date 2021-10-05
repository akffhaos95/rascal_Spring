package com.baseball.rascal.Repository;


import com.baseball.rascal.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUid(String email);
    Optional<User> findByEmail(String email);
}
