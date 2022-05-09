package crp.kr.api.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * packageName: crp.kr.api.soccer.domain
 * fileName   : Stadium
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
@Table(name = "stadiums")
public class Stadium {
    @Id Long stadiumId;
    private String stadiumName;
    private Long homeTeamId;
    private int seatCount;
    private String address;
    private String ddd;
    private String tel;
}
