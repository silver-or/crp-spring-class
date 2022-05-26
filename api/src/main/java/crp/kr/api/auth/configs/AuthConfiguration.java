package crp.kr.api.auth.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * packageName: crp.kr.api.config
 * fileName   : WebSecurityConfig
 * author     : 최은아
 * date       : 2022-05-23
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-23    최은아       최초 생성
 */
@Configuration
public class AuthConfiguration extends WebSecurityConfigurerAdapter { // 외부
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "*/**") // OPTION : 다 (all) // * : 파일, ** : 폴더
                .antMatchers("/"); // 홈 화면 (루트) 는 다 허용
    }

    @Override
    public void configure(HttpSecurity http) throws Exception { // 우선 다 잠그고 허용 지점 정함
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션은 무상태
        http.authorizeRequests()
                .antMatchers("/users/join").permitAll()
                .antMatchers("/users/login").permitAll()
                .anyRequest().authenticated(); // 홈 화면 이후 회원가입만 로그인만 볼 수 있음
        http.exceptionHandling().accessDeniedPage("/users/login"); // 회원가입을 해야 사이트 이용 가능
    }
}
