package crp.kr.api.board.services;

import crp.kr.api.board.domains.Article;
import crp.kr.api.board.domains.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName: crp.kr.api.board.services
 * fileName   : CommentService
 * author     : 최은아
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-09    최은아       최초 생성
 */
public interface CommentService {
    List<Comment> findAll();

    List<Comment> findAll(Sort sort);

    Page<Comment> findAll(Pageable pageable);

    long count();

    String save(Comment comment);

    String delete(Comment comment);
}
