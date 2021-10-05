package com.baseball.rascal.Controller;

import com.baseball.rascal.Model.User;
import com.baseball.rascal.Repository.UserJpaRepo;
import com.baseball.rascal.Model.Result.ListResult;
import com.baseball.rascal.Model.Result.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/* User (Authenticated 토큰 인증됨)
*  1. User Profile (Select)
*  2. Users (Select All) (Admin, Manager)
*  1. User Update
*     User => Success
*  4. User Delete (탈퇴)
*     User => Success
* */

@Api(tags = {"2. User"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserJpaRepo userJpaRepo;
    private final ResponseService responseService;

    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원 조회")
    @GetMapping(value = "/users")
    public ListResult<User> findAllUser() {
        return responseService.getListResult(userJpaRepo.findAll());
    }
}
