package edu.ing.accountmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.ing.accountmanager.model.Account;
import edu.ing.accountmanager.model.User;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("SELECT a FROM Account a WHERE a.type='SAVING' AND a.user=?1")
	Optional<Account> findSavingAccountByUser(User user);
}
