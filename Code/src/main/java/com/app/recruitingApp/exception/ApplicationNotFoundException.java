
package com.app.recruitingApp.exception;

/**
 *
 * @author sgtomar
 * 
 * Custom Exception Class will throw ApplicationNotFoundException Exception whenever application Id not found 
 */
public class ApplicationNotFoundException extends RuntimeException{
     public ApplicationNotFoundException(String message) {
        super(message);
    }
    public ApplicationNotFoundException(String message,Throwable t) {
        super(message,t);
    }
}
