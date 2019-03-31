package tacos.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/h2-console/**").hasRole("ADMIN")// allow h2 console access to admins only
		.anyRequest().authenticated()// all other urls can be access by any authenticated role
		.and().formLogin()// enable form login instead of basic login
		.and().csrf().ignoringAntMatchers("/h2-console/**")// don't apply CSRF protection to /h2-console
		.and().headers().frameOptions().sameOrigin();// allow use of frame to same origin urls
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers("/resources/**", "/static/**");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
  }

  /*
   * @Override protected void configure(AuthenticationManagerBuilder auth) throws
   * Exception { auth.inMemoryAuthentication()
   * .withUser("buzz").password("{noop}infinity").roles("USER") .and()
   * .withUser("admin").password("{noop}password").roles("ADMIN"); }
   */
}