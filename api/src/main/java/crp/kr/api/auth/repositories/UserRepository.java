package crp.kr.api.auth.repositories;

import crp.kr.api.auth.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName: crp.kr.api.repositories
 * fileName   : UserRepository
 * author     : 최은아
 * date       : 2022-05-03
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-03    최은아       최초 생성
 */

@Repository // generator → 존재할 함수 (function*), 와이파이의 개념
// JpaRepository : 임베디드 repository
public interface UserRepository extends JpaRepository<User, Long> {
    String put(User user);

    String login(User user);
}
