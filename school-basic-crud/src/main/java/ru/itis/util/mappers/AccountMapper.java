package ru.itis.util.mappers;


import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.AccountRequest;
import ru.itis.dto.response.AccountResponse;
import ru.itis.model.Account;

@Component
@AllArgsConstructor
public class AccountMapper {

    private final PasswordEncoder passwordEncoder;

    public AccountResponse toResponse(Account account){
        return AccountResponse.builder()
                .id(account.getId())
                .name(account.getName())
                .build();
    }

    public Account toEntity(AccountRequest accountRequest){
        return Account.builder()
                .name(accountRequest.getName())
                .role(Account.Role.USER)
                .state(Account.State.CONFIRMED)
                .hashPassword(passwordEncoder.encode(accountRequest.getPassword()))
                .build();
    }
}
