package com.study.group.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class checkin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer User_ID;
    private String Category;
    private Integer year;
    private String month;
    private Integer day;
    private String week;
    private Integer hour;
    private Integer minute;
}