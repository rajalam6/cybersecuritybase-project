package sec.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {  
        http.headers().xssProtection().disable();
        http.headers().frameOptions().disable();
        http.csrf().disable();
        http
        .authorizeRequests()
            .antMatchers("/logout").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .permitAll()
            .and()
        .logout()
            .permitAll();
    }
}
