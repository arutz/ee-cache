package org.slashdev.rest;

import java.io.Serializable;

public class TestObject implements Serializable {

    private static final long serialVersionUID = 2511605166426625029L;

    public TestObject(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "message='" + message + '\'' +
                '}';
    }
}
