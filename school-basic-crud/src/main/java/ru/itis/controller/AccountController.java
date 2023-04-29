package ru.itis.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dao.AccountDao;
import ru.itis.dto.response.AccountResponse;
import ru.itis.util.mappers.AccountMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private final AccountDao accountDao;
    private final AccountMapper accountMapper;

    @GetMapping
    public List<AccountResponse> getAccount(){
        return accountDao.findAll().stream()
                .map(accountMapper::toResponse)
                .collect(Collectors.toList());
    }

}
