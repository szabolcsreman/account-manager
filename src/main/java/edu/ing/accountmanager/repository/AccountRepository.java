package edu.ing.accountmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ing.accountmanager.model.Account;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
