package Project.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        
		http.authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/delete/**").hasAuthority("ADMIN") 
			.requestMatchers("/", "/booklist").permitAll()
			.anyRequest().authenticated()
		)
		.formLogin(formlogin -> formlogin
			.loginPage("/login").permitAll()
		)
		.logout(logout -> logout
			.permitAll()
		);	
		return http.build();
	}
    @Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
auth.userDetailsService(userDetailsService).passwordEncoder(new
BCryptPasswordEncoder());
}
}
