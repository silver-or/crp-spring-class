package crp.kr.api.board.controllers;

import crp.kr.api.board.domains.Article;
import crp.kr.api.board.domains.Comment;
import crp.kr.api.board.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName: crp.kr.api.board.controllers
 * fileName   : CommentController
 * author     : 최은아
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-09    최은아       최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService service;
    @GetMapping("/findAll")
    public List<Comment> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<Comment> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Comment> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Comment comment) {
        return service.delete(comment);
    }

    @PostMapping("/join")
    public String save(@RequestBody Comment comment) {
        return service.save(comment);
    }
}
