package pl.cgg.offers.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.cgg.offers.models.User;

import javax.sql.DataSource;

public class Configuration {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery(
                        "select username, password, enabled from user where username = ?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_role where username = ?");


//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(password);
//
//        User user = new User();
//        user.setPassword(encodedPassword);
    }
}