package crp.kr.api.soccer.services;

import crp.kr.api.soccer.domains.Team;
import crp.kr.api.soccer.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{
    private final TeamRepository repository;

    @Override
    public List<Team> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Team> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Team> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(Team team) {
        repository.delete(team);
        return null;
    }

    @Override
    public String save(Team team) {
        repository.save(team);
        return null;
    }

    @Override
    public Optional<Team> findById(Long teamId) {
        return repository.findById(teamId);
    }

    @Override
    public boolean existsById(Long teamId) {
        return repository.existsById(teamId);
    }
}
