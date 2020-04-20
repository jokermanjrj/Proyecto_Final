package org.apache.struts.calendar.model;

/**
 * Model class that stores a message.
 * @author Bruce Phillips
 *
 */
public class DayStore {
    
    private String message;
    
    public DayStore() {
        message = "Hello Struts User";
    }

    public String getDay() {
        return message;
    }

}
