package com.baseball.rascal.Repository;


import com.baseball.rascal.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountJpaRepo extends JpaRepository<Account, Integer> {
    Optional<Account> findByUid(String email);
    Optional<Account> findByEmail(String email);
}
