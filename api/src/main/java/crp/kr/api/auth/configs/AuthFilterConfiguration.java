package crp.kr.api.auth.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

/**
 * packageName: crp.kr.api.config
 * fileName   : SecurityConfig
 * author     : 최은아
 * date       : 2022-05-23
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-23    최은아       최초 생성
 */
@RequiredArgsConstructor
public class AuthFilterConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> { // 내부
//    private final
    @Override
    public void configure(HttpSecurity builder) throws Exception {
        super.configure(builder);
    }
}
