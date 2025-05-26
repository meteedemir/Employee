package com.example.EmployeeCRUD.exception;

public class NoSuchEmployeeExistsException extends RuntimeException{
    public String message;

    public NoSuchEmployeeExistsException(){
    }
    public NoSuchEmployeeExistsException(String msg){
        super(msg);
        this.message=msg;
    }
}
