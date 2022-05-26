package crp.kr.api.user.controllers;

import crp.kr.api.auth.domains.Messenger;
import crp.kr.api.user.domains.User;
import crp.kr.api.user.domains.UserDTO;
import crp.kr.api.user.services.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName: crp.kr.api.controllers
 * fileName   : UserController
 * author     : 최은아
 * date       : 2022-05-03
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-03    최은아       최초 생성
 */

@CrossOrigin(origins = "*", allowedHeaders = "*") // 내 상대방의 출처를 밝힘 // 로컬 -> 출처가 어디든 다 허용한다.
@Api(tags = "users") // 외부에서 users 라는 단어가 있는 것만 허용
@RestController // @Component의 자식
@RequiredArgsConstructor // 필수 파라미터 → 리액트에서 props → 자식
@RequestMapping("/users")
public class UserController {
    /*
    private UserService service;
    public UserController(UserService service){
        service = new UserServiceImpl();
    }
    */
    private final UserService service; // 자동으로 controller의 생성자 안에 service가 들어감 → controller가 자식, service가 부모
    private final ModelMapper modelMapper;

    // switch-case의 default 느낌
    @PostMapping("/login")
    @ApiOperation(value = "${UserController.login}")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Something Wrong"),
            @ApiResponse(code = 422, message = "유효하지 않은 ID / PW")
    })
    public ResponseEntity<UserDTO> login(@ApiParam("Login User") @RequestBody UserDTO user) { // Entity는 실제 값
        return ResponseEntity.ok(service.login(user));
    }

    @GetMapping("/logout")
    public ResponseEntity<Messenger> logout(@RequestBody User user) {
        return ResponseEntity.ok(service.logout());
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findAll/sort")
    public ResponseEntity<List<User>> findAll(Sort sort) {
        return ResponseEntity.ok(service.findAll(sort));
    }

    @GetMapping("/findAll/pageable")
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/count")
    public ResponseEntity<Messenger> count() {
        return ResponseEntity.ok(service.count());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> delete(@RequestBody User user) { // 관리자
        return ResponseEntity.ok(service.delete(user));
    }

    @PostMapping("/join")
    @ApiOperation(value = "${UserController.join}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something Wrong"),
            @ApiResponse(code = 403, message = "승인 거절"),
            @ApiResponse(code = 422, message = "중복된 ID")
    })
    public ResponseEntity<Messenger> save(@ApiParam("Join User") @RequestBody UserDTO user) { // User라는 Entity를 외부에서 아예 안 보이게 함
        System.out.println("회원가입 정보 : " + user.toString()); // 나중에 지울 예정. sout은 있으면 안 됨
        return ResponseEntity.ok(service.save(user)); // 인스턴스가 아니라 User라는 class (박스, 공간) 에 담아라 -> set 안 함 -> 자동으로 인스턴스화가 됨
        /*
        * 보안 취약 -> map 사용 (은닉화)
        * User.builder().password(user.getPassword()).build();
        * */
    }

    @GetMapping("/findById/{userid}")
    public ResponseEntity<Optional<User>> findById(@PathVariable String userid) { // path = url → {userid}
        return ResponseEntity.ok(service.findById(userid));
    }

    @GetMapping("/existsById/{userid}")
    public ResponseEntity<Messenger> existsById(@PathVariable String userid) {
        return ResponseEntity.ok(service.existsById(userid));
    }

}
