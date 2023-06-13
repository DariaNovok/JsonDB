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
    private List<Attribute> stroki;
    private String description;
}
