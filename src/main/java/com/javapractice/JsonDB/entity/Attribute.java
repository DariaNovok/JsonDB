package com.javapractice.JsonDB.entity;
public class Attribute {
    private String name;
    private String type;//string, int, float
    private int length;
    private Long id;
    private String value;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Long getId() {
        return id;
    }

     public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return value;
    }

    public void setComment(String comment) {
        this.value = comment;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

