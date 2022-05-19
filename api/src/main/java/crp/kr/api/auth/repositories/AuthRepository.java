package crp.kr.api.auth.repositories;

import crp.kr.api.auth.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName: crp.kr.api.auth.repositories
 * fileName   : AuthRepository
 * author     : 최은아
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-09    최은아       최초 생성
 */

interface AuthCustomRepository {

}

@Repository
public interface AuthRepository extends JpaRepository<User, Long>, AuthCustomRepository {
}
