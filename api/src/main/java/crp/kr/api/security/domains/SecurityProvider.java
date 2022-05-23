package crp.kr.api.security.domains;

import crp.kr.api.auth.domains.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

/**
 * packageName: crp.kr.api.security.domains
 * fileName   : SecurityProvider
 * author     : 최은아
 * date       : 2022-05-23
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-23    최은아       최초 생성
 */
@Log
@Component
@RequiredArgsConstructor
public class SecurityProvider implements AuthenticationProvider { // Provider : 외부 (Spring Security 라이브러리)
    private final UserDetailsServiceImpl service;

    // 외부에서 주입되는 값
    @Value("${security.jwt.token.security-key:secret-key}")
    private String securityKey;
    @Value("${security.jwt.token.expiration-length:3600000}")
    private long validityInMs = 3600000; // 유효시간 : 1h

    @PostConstruct
    protected void init() {
        securityKey = Base64.getEncoder().encodeToString(securityKey.getBytes());
        log.info("securityKey : " + securityKey);
    }

    public String createToken(String username, List<Role> roles) {
        return "";
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
