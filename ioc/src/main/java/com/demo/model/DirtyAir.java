package com.demo.model;

import org.springframework.stereotype.Component;

@Component
public class DirtyAir implements IAir {

    @Override
    public String toString() {
        return "DirtyAir";
    }
}
