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

interface UserCustomRepository {
    String put(User user);

    String login(User user);
}

@Repository // generator → 존재할 함수 (function*), 와이파이의 개념
// JpaRepository : 임베디드 repository
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository { // 인터페이스는 다중 상속 가능 (일반 클래스 불가)

}
