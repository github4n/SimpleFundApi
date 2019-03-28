package com.flannep.financial.simplefundapi.exception;

public class FundIDNotExistException extends Exception {
    public FundIDNotExistException() {
        super();
    }

    public FundIDNotExistException(String msg) {
        super(msg);
    }
}
