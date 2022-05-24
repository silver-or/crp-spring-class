package crp.kr.api.security.domains;

import com.sun.istack.NotNull;
import crp.kr.api.auth.domains.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: crp.kr.api.security.domains
 * fileName   : UserDetailsImpl
 * author     : 최은아
 * date       : 2022-05-23
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-23    최은아       최초 생성
 */
@Getter
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private final long userid; // 컴퓨터가 인증 기호 (토큰) 를 인지하는 방법
    private final String username; // 개발자가 인증 기호를 인지하는 방법 → 리액트에 전달 // 내부적으로 인증 기호가 어떻게 생겼는지는 모름
    @JsonIgnore private final String password;
    private final String name;
    private final String email; // 전달 중에 값 변경되면 안 됨

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(user.getUserId(), user.getUserName(), user.getPassword(),
                user.getName(), user.getEmail(), authorities);
    }

    private final Collection<? extends GrantedAuthority> authorities; // ? : 와일드카드 (뭐인지 모르겠지만 가져와라 = 임의의 어떤 것. 기호이지 타입이 아님) // 어떤 객체의 자시만 들어오게 해라.

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
