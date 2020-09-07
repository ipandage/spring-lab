package com.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

    IAir air;

    @Autowired(required = false) //对构造函数进行标注
    public Person(@Qualifier("dirtyair") IAir air) {
        this.air = air;
    }

    public void breath() {
        System.out.println(this.air.toString());
    }
}
