package ru.itis.security.details;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.dao.AccountDao;

@Component
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final AccountDao accountDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetail(accountDao.findAccountByName(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found")));
    }
}
