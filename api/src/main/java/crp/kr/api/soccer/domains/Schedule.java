package crp.kr.api.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * packageName: crp.kr.api.soccer.domain
 * fileName   : Schedule
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
@Table(name = "schedules")
public class Schedule {
    @Id Long id;
    @Column(nullable = false) private Long stadiumId;
    @Column(nullable = false) private String scheDate;
    private String gubun;
    private Long homeTeamId;
    private Long awayTeamId;
    private int homeScore;
    private int awayScore;
}
