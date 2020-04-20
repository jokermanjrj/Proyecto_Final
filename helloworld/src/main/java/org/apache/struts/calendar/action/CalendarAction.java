package org.apache.struts.calendar.action;

import org.apache.struts.calendar.model.DayStore;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Acts as a Struts 2 controller that responds
 * to a user action by setting the value
 * of the Message model class, and returns a String 
 * result.
 * @author Bruce Phillips
 *
 */
public class CalendarAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * The model class that stores the message
     * to display in the view.
     */
    private DayStore dayStore;

    /*
     * Creates the MessageStore model object and 
     * returns success.  The MessageStore model
     * object will be available to the view.
     * (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    
    public String execute() {
        dayStore = new DayStore() ;    
        return SUCCESS;
        
    }

    public DayStore getDayStore() {
    	System.out.println("Mensaje de retorno"+dayStore);
        return dayStore;
    }

}
