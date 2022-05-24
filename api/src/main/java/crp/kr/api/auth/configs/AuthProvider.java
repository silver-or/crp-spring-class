package crp.kr.api.auth.configs;

import crp.kr.api.auth.domains.Auth;
import crp.kr.api.user.domains.Role;
import crp.kr.api.auth.services.AuthServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
public class AuthProvider implements AuthenticationProvider { // Provider : 외부 (Spring Security 라이브러리)
    private final AuthServiceImpl service; // service가 안에 있으므로 컨트롤러의 포지션

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
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority()))
                .filter(Objects::nonNull).collect(Collectors.toList())
        );
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMs);
        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails auth = service.loadUserByUsername(token);
        return new UsernamePasswordAuthenticationToken(auth.getAuthorities(), "", auth.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody().getSubject(); // 입력한 securityKey parsing
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) throws Exception {
        try {
            Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new Exception();
        }
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
