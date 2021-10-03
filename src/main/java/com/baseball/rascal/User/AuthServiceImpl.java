package com.baseball.rascal.User;

import com.baseball.rascal.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final AuthDao authDao;

    @Override
    public List<User> getUsers() throws ExecutionException, InterruptedException {
        return authDao.getUsers();
    }
}
