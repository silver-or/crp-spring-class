package crp.kr.api.soccer.domains;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @Column(name = "schedule_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private long scheduleNo;
    private String scheDate;
    private String gubun;
    private String hometeamId;
    private String awayteamId;
    private String homeScore;
    private String awayScore;
    private String stadiumId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_no")
    private Stadium stadium;
}
