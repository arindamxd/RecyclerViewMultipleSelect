package com.arindam.androidmultiple.model;

import java.io.Serializable;

/**
 * Created by Arindam Karmakar on 13/11/2017.
 */

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String emailId;

    private boolean isSelected;

    public Student() {
        /* Empty Constructor */
    }

    public Student(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;

    }

    public Student(String name, String emailId, boolean isSelected) {
        this.name = name;
        this.emailId = emailId;
        this.isSelected = isSelected;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean isSelected) { this.isSelected = isSelected; }
}
