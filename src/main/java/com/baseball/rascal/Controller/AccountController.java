package com.baseball.rascal.Controller;

import com.baseball.rascal.Model.Account;
import com.baseball.rascal.Model.Result.ListResult;
import com.baseball.rascal.Model.Result.ResponseService;
import com.baseball.rascal.Repository.AccountJpaRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/* Account (Authenticated 토큰 인증됨)
*  1. Account Profile (Select)
*  2. Account (Select All) (Admin, Manager)
*  1. Account Update
*     Account => Success
*  4. Account Delete (탈퇴)
*     Account => Success
* */

@Api(tags = {"2. Account"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountJpaRepo accountJpaRepo;
    private final ResponseService responseService;

    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원 조회")
    @GetMapping(value = "/account")
    public ListResult<Account> findAllAccount() {
        return responseService.getListResult(accountJpaRepo.findAll());
    }
}
