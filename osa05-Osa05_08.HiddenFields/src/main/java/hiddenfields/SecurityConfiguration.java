
package hiddenfields;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author sonja
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated();
        
        http.formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }
    
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        
        UserDetails user = User.withDefaultPasswordEncoder() // deprekoitu mutta toimii yhä
                               .username("user")
                               .password("password")
                               .authorities("USER")
                               .build();        
        manager.createUser(user);
        
        UserDetails admin = User.withDefaultPasswordEncoder()
                               .username("postman")
                               .password("pat")
                               .authorities("POSTER")
                               .build();
        manager.createUser(admin);
        
        return manager;
    }
}
