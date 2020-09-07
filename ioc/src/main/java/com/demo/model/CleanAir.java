package com.demo.model;

import org.springframework.stereotype.Component;

@Component
public class CleanAir implements IAir {

    @Override
    public String toString() {
        return "CleanAir";
    }
}
