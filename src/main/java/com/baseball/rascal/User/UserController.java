package com.baseball.rascal.User;

import com.baseball.rascal.Model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

/* User
*  1. Login
*     id, password => token, User ( frontend에서 저장)
*  2. Register
*     User => Success
*  3. User Update
*     User => Success
*  4. User Delete
*     User => Success
* */

@Api(tags = {"2. User"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final AuthService authService;

    /* test */
    @ApiOperation(value="getUsers")
    @GetMapping("/users")
    public ResponseEntity<Object> getUsers() throws ExecutionException, InterruptedException {
        List<User> list = authService.getUsers();
        System.out.println(list);
        return ResponseEntity.ok().body(list);
    }

}
