package org.apache.struts.register.model;


/**
 * Models a Person who registers.
 * @author bruce phillips
 *
 */
public class Person {
    private String firstName;
    private String password;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return password;
    }

    public void setLastName(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String toString() {
        return "First Name: " + getFirstName() + " Last Name:  " + getLastName() + 
        " Email:      " + getEmail();
    }
}
