package br.com.forum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.forum.config.Constants;
import br.com.forum.enumerator.Roles;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String PATH = Constants.TOPICOS;

	@Autowired
	private IAutenticacaoService autenticacaoService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Configure AuthenticationManager para que ele saiba de onde carregar o usuário
		// para credenciais correspondentes Use BCryptPasswordEncoder.
		auth.userDetailsService(autenticacaoService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Configurações de autenticação
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		        auth
//		          .inMemoryAuthentication()
//		          .withUser("user")
//		          .password(encoder.encode("password"))
//		          .roles("USER")
//		          .and()
//		          .withUser("admin")
//		          .password(encoder.encode("admin"))
//		          .roles("USER", "ADMIN");
//	}

	// Configurações de autorização
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, Constants.AUTH).permitAll()
				.antMatchers(HttpMethod.GET, PATH + "/**").hasAnyRole(Roles.ADMIN.toString(), Roles.USER.toString())
				.antMatchers(HttpMethod.POST, PATH).hasRole(Roles.ADMIN.toString())
				.antMatchers(HttpMethod.PUT, PATH + "/**").hasRole(Roles.ADMIN.toString())
				.antMatchers(HttpMethod.PATCH, PATH + "/**").hasRole(Roles.ADMIN.toString())
				.antMatchers(HttpMethod.DELETE, PATH + "/**").hasRole(Roles.ADMIN.toString()).anyRequest()
				.authenticated();
		httpSecurity.csrf().disable();
		httpSecurity.formLogin().disable();
		// Certifique-se de usar a sessão sem estado; sessão não será usada para
		// armazenar o estado do usuário.	
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
		httpSecurity.headers().frameOptions().disable();
		// Adicione um filtro para validar os tokens a cada solicitação.
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
