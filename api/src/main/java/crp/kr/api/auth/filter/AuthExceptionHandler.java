package crp.kr.api.auth.filter;

import crp.kr.api.auth.domains.Messenger;
import crp.kr.api.auth.exception.ErrorCode;
import crp.kr.api.auth.exception.LoginRunnerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

/**
 * packageName: crp.kr.api.auth.filter
 * fileName   : AuthException
 * author     : 최은아
 * date       : 2022-05-25
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-25    최은아       최초 생성
 */
@Slf4j // lombok에서 제공하는 log
@ControllerAdvice // 컨트롤러 들어가기 직전에 실행 (필터가 자동으로)
public class AuthExceptionHandler {
    @ExceptionHandler(RuntimeException.class) // Exception이 발생했을 때
    protected ResponseEntity<Messenger> handleRuntimeException(RuntimeException e) {
        log.info("handleRuntimeException", e);
        return new ResponseEntity<>(Messenger.builder()
                .code("test").message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SecurityException.class)
    protected ResponseEntity<Messenger> handleSecurityException(SecurityException e){
        log.info("handleSecurityException",e);
        return new ResponseEntity<>(Messenger.builder()
                .code(ErrorCode.AUTHENTICATION_FAILED.getCode())
                .message(e.getMessage())
                .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(LoginRunnerException.class)
    protected ResponseEntity<Messenger> handleLoginRunnerException(LoginRunnerException e){
        log.info("handleLoginRunnerException",e);
        return new ResponseEntity<>(Messenger.builder()
                .code(ErrorCode.LOGIN_FAILED.getCode())
                .message(ErrorCode.LOGIN_FAILED.getMsg())
                .status(ErrorCode.LOGIN_FAILED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<Messenger> handleBadCredentialsException(BadCredentialsException e){
        log.info("handleBadCredentialsException",e);
        return new ResponseEntity<>(Messenger.builder()
                .code(ErrorCode.ACCESS_DENIED.getCode())
                .message(ErrorCode.ACCESS_DENIED.getMsg())
                .status(ErrorCode.ACCESS_DENIED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Messenger> handleAccessDeniedException(AccessDeniedException e){
        log.info("handleAccessDeniedException",e);
        return new ResponseEntity<>(Messenger.builder()
                .code(ErrorCode.ACCESS_DENIED.getCode())
                .message(ErrorCode.ACCESS_DENIED.getMsg())
                .status(ErrorCode.ACCESS_DENIED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    protected ResponseEntity<Messenger> handleInsufficientAuthenticationException(InsufficientAuthenticationException e){
        log.info("handleAInsufficientAuthenticationException",e);
        return new ResponseEntity<>(Messenger.builder()
                .code(ErrorCode.AUTHENTICATION_FAILED.getCode())
                .message(ErrorCode.AUTHENTICATION_FAILED.getMsg())
                .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }
}
