package crp.kr.api.board.services;

import crp.kr.api.board.domains.Comment;
import crp.kr.api.board.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName: crp.kr.api.board.services
 * fileName   : CommentServiceImpl
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
public class CommentServiceImpl implements CommentService{
    private final CommentRepository repository;

    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Comment> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(Comment comment) {
        repository.delete(comment);
        return null;
    }

    @Override
    public String save(Comment comment) {
        repository.save(comment);
        return null;
    }
}
