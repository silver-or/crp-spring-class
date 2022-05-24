package crp.kr.api.auth.domains;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.List;

/**
 * packageName: crp.kr.api.auth.domains
 * fileName   : UserDto
 * author     : 최은아
 * date       : 2022-05-24
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-24    최은아       최초 생성
 */
@Component @Data
public class UserDto { // 리액트에서 담음 // 감시 대상 (이후 User로 상태 변화)
    @ApiModelProperty(position = 0) private long userId;
    @ApiModelProperty(position = 1) private String userName;
    @ApiModelProperty(position = 2) private String password;
    @ApiModelProperty(position = 3) private String name;
    @ApiModelProperty(position = 4) private String email;
    @ApiModelProperty(position = 5) private String regDate;
    @ApiModelProperty(position = 6) private String token;
    @ApiModelProperty(position = 7) private List<Role> roles; // 한 명의 유저는 여러 개의 role을 갖는다.

}
