package com.example.baitapvietis.security;

import com.example.baitapvietis.service.UserDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WedSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetail userService;

    public WedSecurityConfig(UserDetail userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService) // Cung cáp userservice cho spring security
                .passwordEncoder(passwordEncoder()); // cung cấp password encoder
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//                những gì chúng ta muốn cho phép, chúng ta sẽ xài method .permit()
//                còn những gì cấm hoặc yêu cầu xác thực sẽ dùng .authenticated()
    http
            .authorizeRequests()
            .antMatchers("/", "/register" ,"/save").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
//            .antMatchers("/admin").access("hasRole('ROLE_Admin')")
            .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
            .and()
            .formLogin() // Cho phép người dùng xác thực bằng form login
            .loginPage("/login").permitAll()
            .defaultSuccessUrl("/admin").permitAll() // Tất cả đều được truy cập vào địa chỉ này
            .and()
            .logout() // Cho phép logout
            .permitAll();

}
}
