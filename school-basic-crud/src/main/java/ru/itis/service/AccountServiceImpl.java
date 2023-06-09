package ru.itis.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dao.AccountDao;
import ru.itis.dto.request.AccountRequest;
import ru.itis.dto.response.AccountResponse;
import ru.itis.model.Account;
import ru.itis.util.mappers.AccountMapper;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;
    private final AccountMapper accountMapper;

    @Override
    public AccountResponse findAccount(UUID id) {
        return accountMapper.toResponse(accountDao.findById(id).orElseThrow());
    }

    @Override
    public AccountResponse addAccount(AccountRequest accountRequest) {
        return accountMapper.toResponse(accountDao.save(accountMapper.toEntity(accountRequest)));
    }
}
