package crp.kr.api.soccer.domains;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
* packageName: crp.kr.api.soccer.domain
* fileName   : player
* author     : 최은아
* date       : 2022-05-09
* desc       :
* ================================
*  DATE          AUTHOR        NOTE
* ================================
*  2022-05-09    최은아       최초 생성
*/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(name = "player_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long playerNo;
    @Column(nullable = false) private String playerId;
    @Column(nullable = false) private String playerName;
    private String ePlayerName;
    private String nickname;
    private String joinYyyy;
    private String position;
    private String backNo;
    private String nation;
    private String birthDate;
    private String solar;
    private String height;
    private String weight;
    private String teamId;

    @ManyToOne
    @JoinColumn(name = "team_no")
    private Team team;
}
