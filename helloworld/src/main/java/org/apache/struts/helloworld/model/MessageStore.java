package org.apache.struts.helloworld.model;

/**
 * Model class that stores a message.
 * @author Bruce Phillips
 *
 */
public class MessageStore {
    
   // private String message,title;
   //private int id;
    private MessageArray messageArray[];
    
    public MessageStore() {
        /*message = "mensaje de prueba";
        id = 1;
        title = "Cocinar";*/
    	messageArray = new MessageArray[3];
    	messageArray[0] = new MessageArray("Titulo","Ruben",1);
    	messageArray[1] = new MessageArray("Titulo1","Fernando",2);
    	
    }
    
    public MessageArray[] getMessage() {
    	 System.out.println("Mensaje impreso del array ---> "+messageArray[1].getMessage());
    	 return messageArray;
    }
    
/*
    public String getMessage() {
        return message;
    }
    
    public String getTitle() {
        return title;
    }
    
    
    public int getId() {
    	return id;
    }
*/
}
