package pe.edu.upc.demo;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource data;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(data)
                .usersByUsernameQuery("select username_paciente , pswrd_paciente , 1 from paciente  "
                        + " where username_paciente = ?")
                .authoritiesByUsernameQuery("select username_paciente , rol_paciente "
                        + " from paciente "
                        + " where username_paciente =?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests().antMatchers("/images/**", "/", "/login").
                permitAll()
                .antMatchers("/aadmins/**").hasAnyAuthority("ROLE_ADMINISTRADOR")
                .antMatchers("/ppacientes/**").hasAnyAuthority("ROLE_PACIENTE", "ROLE_ADMINISTRADOR")
                .antMatchers("/ccamas/**").hasAnyAuthority("ROLE_PACIENTE", "ROLE_ADMINISTRADOR")
                .antMatchers("/hhospitals/**").hasAnyAuthority("ROLE_PACIENTE", "ROLE_ADMINISTRADOR")
                .antMatchers("/mmedicos/**").hasAnyAuthority("ROLE_PACIENTE", "ROLE_ADMINISTRADOR")
                .antMatchers("/rreservas/**").hasAnyAuthority("ROLE_PACIENTE", "ROLE_ADMINISTRADOR")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/mmedicos/listmedic").permitAll().
                failureUrl("/login?error=true").and().
                logout().permitAll().logoutSuccessUrl("/login?logout").
                deleteCookies("JSESSIONID");

    }

}
