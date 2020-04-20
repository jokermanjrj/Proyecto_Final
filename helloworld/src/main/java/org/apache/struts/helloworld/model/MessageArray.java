package org.apache.struts.helloworld.model;

public class MessageArray {
	private String message,title;
	private int id;
	
	 
	    public MessageArray(String message, String title, int id) {
		super();
		this.message = message;
		this.title = title;
		this.id = id;
	}


		public String getMessage() {
	        return message;
	    }
	    
	    public String getTitle() {
	        return title;
	    }
	    
	    
	    public int getId() {
	    	return id;
	    }
	    
}
