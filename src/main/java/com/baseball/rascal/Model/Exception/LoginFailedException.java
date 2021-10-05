package com.baseball.rascal.Model.Exception;

import lombok.Getter;

@Getter
public class LoginFailedException extends RuntimeException {

    public LoginFailedException() {
        super();
    }
}
