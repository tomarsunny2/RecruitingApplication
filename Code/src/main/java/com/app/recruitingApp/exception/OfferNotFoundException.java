
package com.app.recruitingApp.exception;

/**
 *  
 * @author sgtomar
 * Custom Exception Class will throw OfferNotFound Exception whenever Offer Id not found 
 * 
 */
public class OfferNotFoundException extends RuntimeException{
    
    public OfferNotFoundException(String message) {
        super(message);
    }
    public OfferNotFoundException(String message,Throwable t) {
        super(message,t);
    }
    
}
