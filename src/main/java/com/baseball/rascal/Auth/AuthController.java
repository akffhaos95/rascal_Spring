package com.baseball.rascal.Auth;

import com.baseball.rascal.Model.User;
import com.baseball.rascal.User.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Api(tags = {"1. Auth"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    //@ApiOperation(value="Login")
   // @PostMapping("/login")
    //public ResponseEntity<Object> login(@ApiParam(value="Email", required = true) @RequestParam String email,
     //                                   @ApiParam(value="Password", required = true) @RequestParam String password) {
        // userJpa에서 저장된 아이디 조회(없다면 exception)
        // 있다면 password hash 인코딩, 조회한 아이디의 비밀번호 해쉬랑 비교(틀리면 exception)
        // 토큰 생성
        // 리턴
   // }
}
