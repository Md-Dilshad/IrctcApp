package com.dilshad.IrctcApp.model.exception;

public class ExpiredTicketException extends RuntimeException{
    public ExpiredTicketException(String msg){
        super(msg);
    }
}
