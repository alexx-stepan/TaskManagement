package com.alexxstepan.taskmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableJpaRepositories(basePackages = {"com.alexxstepan.taskmanagement.dao.repositories"})
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private class MyPasswordEncoder implements PasswordEncoder {
		@Override
		public String encode(CharSequence rawPassword) {
			return rawPassword.toString();
		}

		@Override
		public boolean matches(CharSequence rawPassword, String encodedPassword) {
			return true;
		}
	}

	@Configuration
	protected class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.httpBasic()
					.and()
					.cors()
					.and()
					.authorizeRequests().antMatchers("/", "/login").permitAll()
					.anyRequest().authenticated()
					.and()
					.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
			http
					.logout()
					.logoutUrl("/api/logout")
					.logoutSuccessUrl("/login");
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth
					.inMemoryAuthentication()
					.passwordEncoder(new MyPasswordEncoder())
					.withUser("qwerty").password("qwerty").roles("USER");
		}
	}
}
