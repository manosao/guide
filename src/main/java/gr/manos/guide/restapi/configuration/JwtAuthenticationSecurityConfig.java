package gr.manos.guide.restapi.configuration;

import gr.manos.guide.restapi.jwt.JWTAuthenticationFilter;
import gr.manos.guide.restapi.jwt.JWTAuthorizationFilter;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JwtAuthenticationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String SIGN_UP_URL = "/users/sign-up";
	
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public JwtAuthenticationSecurityConfig( BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
//    private UserDetailsService userDetailsService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    
//    public JwtAuthenticationSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//    	this.userDetailsService = userDetailsService;
//    	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http.csrf().disable()
        // do not create session
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        
        .and().authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()));
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      // Create a default account
      auth.inMemoryAuthentication()
          .withUser("user")
          .password("user")
          .roles("USER")
          .and()
	      .withUser("admin")
	      .password("admin")
	      .roles("ADMIN");
    }
    
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }
}