package com.example.App.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.App.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private final PasswordEncoder passwordEncoder;
    @Override
    @Bean // Adding students
    protected UserDetailsService userDetailsService() {
        UserDetails annaSmithUser = User.builder()
                .username("annasmith")
                .password(passwordEncoder.encode("password"))
            //    .roles(STUDENT.name()) // ROLE_ABC
                .authorities(STUDENT.getGrantedAuthorities())
                .build();
        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("password123"))
            //    .roles(ApplicationUserRole.ADMIN.name()) //ROLE ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();
        UserDetails tomUser = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password123"))
            //    .roles(ApplicationUserRole.ADMINTRAINEE.name()) //ROLE ADMIN
                .authorities(ADMINTRAINEE.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(
                annaSmithUser,
                lindaUser,
                tomUser
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Spring sends an CSRF (Cross Site Request Forgery)
                // as a cookie to the front end server
                // Client submits form with token -> post/put/delete -> frontend validates
                // Non Browser client = disable
                .csrf().disable() // Disables api permission
                .authorizeRequests()
                // WhiteListing URL's below
                .antMatchers("/","index","/css/*","/js*").permitAll()
                .antMatchers("/students/**").hasRole(STUDENT.name())
                // Permissions based on ROLE
                // Order of these antMatchers MATTER!!
                /* These have the same functionality as the @PreAuthorize in Controller Class
                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                */
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
