package crp.kr.api.auth.domains;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName: crp.kr.api.security.domains
 * fileName   : Messenger
 * author     : 최은아
 * date       : 2022-05-23
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-23    최은아       최초 생성
 */
@Builder @Getter
public class Messenger { // DB 설정 X // 리액트(화면)에 던짐 // 로그인 안 풀리게 하는 역할
    private String message, code, token;
    private int status;
}
