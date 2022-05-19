package crp.kr.api.soccer.repositories;

import crp.kr.api.soccer.domains.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName: crp.kr.api.soccer.repositories
 * fileName   : PlayerRepository
 * author     : 최은아
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-09    최은아       최초 생성
 */

interface PlayerCustomRepository {

}

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>, PlayerCustomRepository {
}
