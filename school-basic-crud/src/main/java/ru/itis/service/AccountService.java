package ru.itis.service;

import ru.itis.dto.request.AccountRequest;
import ru.itis.dto.response.AccountResponse;
import ru.itis.model.Account;

import java.util.UUID;

public interface AccountService {

    public AccountResponse findAccount(UUID id);
    public AccountResponse addAccount(AccountRequest accountRequest);
}
