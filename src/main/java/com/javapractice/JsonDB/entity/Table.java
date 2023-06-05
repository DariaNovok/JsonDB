package com.javapractice.JsonDB.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    private Long Id;
    private String name;
    private String stroka;
    private ArrayList<Attribute> stroki;
    private String description;

    //private LocalDate createdAt;


    //public Table() {
    //    this.createdAt = LocalDate.now();
    //}

    @Override
    public String toString(){
        return "";
    }
}
