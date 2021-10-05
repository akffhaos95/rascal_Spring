package com.baseball.rascal.Model.Result;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {
    // enum으로 api 요청 결과에 대한 code, message를 정의
    public enum CommonResponse {
        SUCCESS(0, "성공하였습니다."), FAIL(-1, "실패하였습니다.");
        int code;
        String msg;

        CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
        public int getCode() { return code; }
        public String getMsg() { return msg; }
    }

    // 단일 결과 만드는 메소드 (단일 데이터가 필요할 때)
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    // 다중 결과 만드는 메소드 (리스트 데이터가 필요할 때)
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);
        return result;
    }

    // 성공 결과만 처리하는 메소드 (성공 실패 여부만 포함할 때)
    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    // 실패 결과만 처리하는 메소드 (성공 실패 여부만 포함할 때)
    public CommonResult getFailResult() {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
        return result;
    }

    public CommonResult getFailResult(int code, String msg) {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
}

