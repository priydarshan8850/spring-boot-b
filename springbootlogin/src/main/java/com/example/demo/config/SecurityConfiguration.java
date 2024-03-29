package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				 "/registration**",
	                "/js/**",
	                "/css/**",
	                "/img/**").permitAll()
		.antMatchers("/showNewMovieForm").hasAnyAuthority("ADMIN").antMatchers("/showFormForUpdate/**")
		.hasAnyAuthority("ADMIN").antMatchers("/deleteMovie/**").hasAuthority("ADMIN").antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll().and().exceptionHandling().accessDeniedPage("/");
		http.csrf().disable(); http.headers().frameOptions().disable();
		
		
		/*
		 * http.authorizeRequests().antMatchers("/").hasAnyAuthority("USER", "ADMIN")
		 * .antMatchers("/showNewMovieForm").hasAnyAuthority("ADMIN").antMatchers(
		 * "/showFormForUpdate/**")
		 * .hasAnyAuthority("ADMIN").antMatchers("/deleteMovie/**").hasAuthority(
		 * "ADMIN")
		 * .antMatchers("/h2-console/**").permitAll().anyRequest().authenticated().and()
		 * .formLogin().permitAll()
		 * .and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/403"
		 * );
		 * 
		 * http.csrf().disable(); http.headers().frameOptions().disable();
		 */
	}

}
