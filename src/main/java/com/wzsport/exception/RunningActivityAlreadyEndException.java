package com.wzsport.exception;

public class RunningActivityAlreadyEndException extends RuntimeException {

	private static final long serialVersionUID = 153626547270081826L;

	public RunningActivityAlreadyEndException() {
        super();
    }
	
    public RunningActivityAlreadyEndException(String message) {
        super(message);
    }
}
