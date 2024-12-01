package com.simple.com.example.bean;

public class Mybean {
    private Long id;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Mybean [id=" + id + ", message=" + message + "]";
    }
}

