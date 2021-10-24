package com.bh1ofp.week05autoconfiguration;

import lombok.Data;

@Data
public class StudentInfo {
    private int id;
    private String name;

    public StudentInfo(int id, String name){
        this.id = id;
        this.name = name;
    }

}
