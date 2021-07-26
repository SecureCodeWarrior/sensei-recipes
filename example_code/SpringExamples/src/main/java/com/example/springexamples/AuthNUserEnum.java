package com.example.springexamples;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthNUserEnum {
    public void method() {
        DaoAuthenticationProvider daoauth = new DaoAuthenticationProvider();
        daoauth.setHideUserNotFoundExceptions(false);

        try {

        }
        catch(UsernameNotFoundException e) {
            if(true) {

            } else {
                throw new UsernameNotFoundException(e.getMessage());
            }
        }
    }
}
