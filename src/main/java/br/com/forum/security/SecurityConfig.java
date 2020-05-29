package br.com.forum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.forum.config.Constants;
import br.com.forum.enumerator.Roles;
import br.com.forum.security.impl.AutenticacaoService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String PATH = Constants.TOPICOS;
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	// Configurações de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	// Configurações de autorização
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().and()
		        .authorizeRequests()
				.antMatchers(HttpMethod.GET, PATH + "/**").hasAnyRole(Roles.USER.toString())
				.antMatchers(HttpMethod.POST, PATH).hasRole(Roles.USER.toString())
				.antMatchers(HttpMethod.PUT, PATH + "/**").hasRole(Roles.USER.toString())
				.antMatchers(HttpMethod.PATCH, PATH + "/**").hasRole(Roles.USER.toString())
				.antMatchers(HttpMethod.DELETE, PATH + "/**").hasRole(Roles.USER.toString())
				.anyRequest().authenticated();
		httpSecurity.csrf().disable();
		httpSecurity.formLogin().disable();
		httpSecurity.headers().frameOptions().disable();
	}

	// Configurações de recursos estáticos(js, css, imagens, etc...)
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

}
