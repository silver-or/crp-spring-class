package crp.kr.api.auth.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * packageName: crp.kr.api.domains
 * fileName   : User
 * author     : 최은아
 * date       : 2022-05-03
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-03    최은아       최초 생성
 */

@Data
@Component
// 컴포넌트는 property와 method의 집합이다.
// 리액트에서 컴포넌트는 props와 state, 그리고 render()를 가진 순수 함수이다.
@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // unique
    private Long id; // 자동 생성
    @Column(nullable = false) private String userid;
    @Column(nullable = false) private String password;
    @Column(nullable = false) private String email;
    @Column(nullable = false) private String name;
    private String phone;
    private String birth;
    private String address;
}
