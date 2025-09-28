package spring.it.login.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import spring.it.login.service.TaikhoanServices;
@Configuration
public class SecurityConfig {
	@Autowired
	private TaikhoanServices services;
	
	 @Bean
	    public BCryptPasswordEncoder passBcry() {
	        return new BCryptPasswordEncoder();
	 }
	  @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(services);
	        authProvider.setPasswordEncoder(passBcry());
	        return authProvider;
	    }
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/login",  "/register","/css/**").permitAll()
				.anyRequest().authenticated()
				)
		.formLogin(form-> form
				.loginPage("/login")
				.defaultSuccessUrl("/home", true)
				.permitAll()
				)
		.logout(logout->logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll());
		return http.build();
	}
}

