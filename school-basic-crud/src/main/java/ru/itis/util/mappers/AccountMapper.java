package ru.itis.util.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.AccountRequest;
import ru.itis.dto.response.AccountResponse;
import ru.itis.model.Account;

@Component
public class AccountMapper {

    public AccountResponse toResponse(Account account){
        return AccountResponse.builder()
                .id(account.getId())
                .name(account.getName())
                .build();
    }

    public Account toEntity(AccountRequest accountRequest){
        return Account.builder()
                .id(accountRequest.getId())
                .name(accountRequest.getName())
                .build();
    }
}
