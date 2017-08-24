package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource  dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoder);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.
				authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/clothhome").permitAll()
				.antMatchers("/product/cart").permitAll()
				.antMatchers("/registration").permitAll()
				.antMatchers("/checkout").permitAll()
				.antMatchers("/productrest").permitAll()
				.antMatchers("/productrest/{id}").permitAll()
				.antMatchers("/product/deletecart/{id}").permitAll()

                 .antMatchers("/product/cart/").permitAll()
				.antMatchers("/contactsave").permitAll()
				.antMatchers("/productGender/{name}").permitAll()
				.antMatchers("/productGender/male/").permitAll()
				.antMatchers("/androidget").permitAll()
				.antMatchers("/androidpost").permitAll()
				.antMatchers("/product/cart/{name}").permitAll()
				.antMatchers("/product/cart/test/{productname}").permitAll()
				.antMatchers("/salwars").permitAll()
				.antMatchers("/mail").permitAll()
				.antMatchers("/sandals").permitAll()
				.antMatchers("/sarees").permitAll()
				.antMatchers("/shirts").permitAll()
				.antMatchers("/single").permitAll()
				.antMatchers("/skirts").permitAll()
				.antMatchers("/faq").permitAll()
				.antMatchers("/dresses").permitAll()
				.antMatchers("/clothproducts").permitAll()
				.antMatchers("/about").permitAll()
				.antMatchers("/jeans").permitAll()
				.antMatchers("/registeract").permitAll()
				.antMatchers("/guests").permitAll()
				.antMatchers("/tryme").permitAll()
				.antMatchers("/maledressingroom").permitAll()
				.antMatchers("/femaledressingroom").permitAll()
				.antMatchers("/search").permitAll()
				.antMatchers("/guests/{name}").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "user/allusers").hasRole("user")
				.antMatchers("/admin/**").hasAuthority("admin").anyRequest()
				.authenticated().and().csrf().disable().formLogin()
				.loginPage("/login").failureUrl("/login?error=true")
				.defaultSuccessUrl("/clothhome")
				.usernameParameter("email")
				.passwordParameter("password")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/access-denied");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/cloth/**","/room/**");
	}

}