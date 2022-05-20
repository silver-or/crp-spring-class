package crp.kr.api.soccer.services;

import crp.kr.api.soccer.domains.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName: crp.kr.api.soccer.services
 * fileName   : TeamService
 * author     : 최은아
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-09    최은아       최초 생성
 */
public interface TeamService {
    List<Team> findAll();

    List<Team> findAll(Sort sort);

    Page<Team> findAll(Pageable pageable);

    long count();

    String delete(Team team);

    String save(Team team);

    Optional<Team> findById(Long teamNo);

    boolean existsById(Long teamNo);
}
