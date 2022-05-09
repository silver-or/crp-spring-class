package crp.kr.api.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * packageName: crp.kr.api.controllers
 * fileName   : HomeController
 * author     : 최은아
 * date       : 2022-05-03
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-03    최은아       최초 생성
 */

@RestController
public class HomeController {
    @GetMapping("/") // url → 라우터
    public String now(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
}
