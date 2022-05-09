package crp.kr.api.board.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * packageName: crp.kr.api.board.domains
 * fileName   : Article
 * author     : 최은아
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-09    최은아       최초 생성
 */
@Data
@Component
@Entity
@Table(name = "articles")
public class Article {
    @Id Long id;
    private String projects;
    private String startDate;
    private String status;
    private String team;
    private String progress;
    private String action;
}
