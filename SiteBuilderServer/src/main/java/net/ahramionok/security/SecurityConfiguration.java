package net.ahramionok.security;

import net.ahramionok.provider.CustomAuthenticationProvider;
import net.ahramionok.service.UserService;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



/**
 * Created by KIrill on 08.01.2017.
 */
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private RESTAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private RESTAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(customAuthenticationProvider);
        /*builder.inMemoryAuthentication().withUser("kirusha").password("1234").roles("user");
        builder.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username,password, enabled from user where username=?")
        .authoritiesByUsernameQuery("select role_name from role where id_role=(select id_role from user where username=?)");
        System.out.print("  123  ");*/
    }

    @Override

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll();
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.formLogin()
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and().cors()
                .and().csrf().disable().
        logout().logoutUrl("/logout").invalidateHttpSession(true);
    }
}
