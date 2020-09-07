package com.demo.model;

public class XMLFactory {

    public XMLInstance CreateInstance() {
        return new XMLInstance("instance", new CleanAir());
    }

    public static XMLInstance CreateStaticInstance() {
        return new XMLInstance("static instance", new CleanAir());
    }
}
