package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountDao extends JpaRepository<Account, UUID> {

    public Optional<Account> findAccountByName(String name);
}
