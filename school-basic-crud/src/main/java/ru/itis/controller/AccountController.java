package ru.itis.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.dao.AccountDao;
import ru.itis.dto.request.AccountRequest;
import ru.itis.dto.response.AccountResponse;
import ru.itis.service.AccountService;
import ru.itis.util.mappers.AccountMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class AccountController {

    private final AccountDao accountDao;
    private final AccountMapper accountMapper;

    private final AccountService accountService;
    @GetMapping
    public List<AccountResponse> getAccount(){
        return accountDao.findAll().stream()
                .map(accountMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AccountResponse addAccount(@RequestBody AccountRequest accountRequest){
        return accountService.addAccount(accountRequest);
    }

}
