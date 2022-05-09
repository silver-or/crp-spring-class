package crp.kr.api.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Data
@Component
@Entity
@Table(name = "players")
public class Player {
    @Id Long playerId;
    private String playerName;
    private Long teamId;
    private String ePlayerName;
    private String nickname;
    private String joinYyyy;
    private String position;
    private String backNo;
    private String nation;
    private String birthDate;
    private String solar;
    private double height;
    private double weight;
}