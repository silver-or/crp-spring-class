package crp.kr.api.auth.filter;

import crp.kr.api.auth.configs.AuthProvider;
import crp.kr.api.auth.exception.SecurityRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName: crp.kr.api.auth.filter
 * fileName   : AuthFilter
 * author     : 최은아
 * date       : 2022-05-25
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-25    최은아       최초 생성
 */
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter { // 접미사는 보통 그 객체의 기능을 부여함
    private final AuthProvider provider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = provider.resolveToken(request); // filter는 request 안에 들어있는 토큰에 대한 처리만 수행 (판단 X) → provider가 맞는지 틀린지 판단.
        try {
            if(token != null && provider.validateToken(token)) {
                Authentication auth = provider.getAuthentication(token);
                SecurityContextHolder.clearContext();
                SecurityContextHolder.getContext().setAuthentication(auth); // Context는 Bean 객체들이 모인 곳
            }
        }
        catch (SecurityRuntimeException ex) {
            //this is very important, since it guarantees the user is not authenticated at all
            SecurityContextHolder.clearContext();
            response.sendError(ex.getHttpStatus().value(), ex.getMessage());
            return;
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
