package com.baseball.rascal.Controller;

import com.baseball.rascal.Model.Exception.LoginFailedException;
import com.baseball.rascal.Model.Account;
import com.baseball.rascal.Repository.AccountJpaRepo;
import com.baseball.rascal.Model.Result.CommonResult;
import com.baseball.rascal.Model.Result.ResponseService;
import com.baseball.rascal.Model.Result.SingleResult;
import com.baseball.rascal.config.JwtTokenProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;


@Api(tags = {"1. Auth"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AccountJpaRepo AccountJpaRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value = "Login")
    @PostMapping(value="/login")
    public SingleResult<String> login(@ApiParam(value = "email", required = true) @RequestParam("email") String email,
                                      @ApiParam(value = "password", required = true) @RequestParam("password") String password) {
        Account account = AccountJpaRepo.findByEmail(email).orElseThrow(LoginFailedException::new);
        if (!passwordEncoder.matches(password, account.getPassword())){
            throw new LoginFailedException();
        }
        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(account.getUid()), account.getRoles()));
    }

    @ApiOperation(value = "Register")
    @PostMapping(value = "/register")
    public CommonResult register(@ApiParam(value = "Email", required = true) @RequestParam("email") String email,
                                 @ApiParam(value = "Password", required = true) @RequestParam("password") String password,
                                 @ApiParam(value = "Name" , required = true) @RequestParam("name") String name) {
        AccountJpaRepo.save(Account.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .roles(Collections.singletonList("ROLE_Account"))
                .build());
        return responseService.getSuccessResult();
    }

    @ApiOperation(value = "EmailExist")
    @PostMapping(value = "/emailExist")
    public CommonResult emailExist(@ApiParam(value = "Email", required = true) @RequestParam("email") String email) {
        Optional<Account> Account = AccountJpaRepo.findByEmail(email);
        System.out.print(Account);

        return responseService.getSuccessResult();
    }
}
