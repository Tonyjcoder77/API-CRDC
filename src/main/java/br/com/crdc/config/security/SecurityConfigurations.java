package br.com.crdc.config.security;

import br.com.crdc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	//Configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Configuracoes de autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/Empresas").permitAll()
		.antMatchers(HttpMethod.GET, "/Empresas/Max").permitAll()
		.antMatchers(HttpMethod.GET, "/Empresas/Max/*").permitAll()
		.antMatchers(HttpMethod.POST, "/Empresas").permitAll()
		.antMatchers(HttpMethod.GET, "/Empresas/*").permitAll()
		.antMatchers(HttpMethod.POST, "/Empresas/*").permitAll()
		.antMatchers(HttpMethod.GET, "/Transacoes").permitAll()
		.antMatchers(HttpMethod.POST, "/Transacoes").permitAll()
		.antMatchers(HttpMethod.GET, "/Transacoes/*").permitAll()
		.antMatchers(HttpMethod.GET, "/Transacoes/Max").permitAll()
		.antMatchers(HttpMethod.GET, "/Transacoes/Max/*").permitAll()
		.antMatchers(HttpMethod.POST, "/Transacoes/*").permitAll()
		.antMatchers(HttpMethod.POST, "/Transacoes/Cadastrar/*").permitAll()
		.antMatchers(HttpMethod.GET, "/Upload").permitAll()
		.antMatchers(HttpMethod.POST, "/Upload").permitAll()
		.antMatchers(HttpMethod.GET, "/Upload/*").permitAll()
		.antMatchers(HttpMethod.POST, "/Upload/*").permitAll()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
		.antMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
	}
	
	
	//Configuracoes de recursos estaticos(js, css, imagens, etc.)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/h2-console/**", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}
	
}







