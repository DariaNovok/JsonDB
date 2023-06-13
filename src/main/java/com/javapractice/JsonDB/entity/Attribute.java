package com.javapractice.JsonDB.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {
    private Long id;
    private String name;
    private String type;
    private int length;
    private String value;
}

