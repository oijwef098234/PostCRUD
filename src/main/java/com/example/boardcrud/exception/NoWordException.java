package com.example.boardcrud.exception;


public class NoWordException extends RuntimeException {
    public NoWordException(String feild, String noWord) {
        super(feild + "에 금지어 " + noWord + "이(가) 포함되어있습니다.");
    }
}
