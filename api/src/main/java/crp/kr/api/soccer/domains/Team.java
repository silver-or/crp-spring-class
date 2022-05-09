package crp.kr.api.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * packageName: crp.kr.api.soccer.domain
 * fileName   : Team
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
@Table(name = "teams")
public class Team {
    @Id Long teamId;
    private String regionName;
    private String teamName;
    private String eTeamName;
    private String origYyyy;
    private Long stadiumId;
    private String zipCode1;
    private String zipCode2;
    private String address;
    private String ddd;
    private String tel;
    private String fax;
    private String homepage;
    private String owner;
}
