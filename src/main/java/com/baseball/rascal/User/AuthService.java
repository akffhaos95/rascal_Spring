package com.baseball.rascal.User;

import com.baseball.rascal.Model.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface AuthService {
    List<User> getUsers() throws ExecutionException, InterruptedException;
}
