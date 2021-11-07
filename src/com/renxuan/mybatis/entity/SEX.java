package com.renxuan.mybatis.entity;

public enum SEX {
    /**
     * female.
     */
    FEMALE(0, "Å®"),
     /**
     * male.
     */
    MALE(1,"ÄÐ"),
    /**
     * unknown.
     */
    UNKNOWN(2, "Î´Öª");

    private int value;
    private String description;

    SEX(int value, String description) {
        this.value = value;
        this.description = description;
    }
    
 
    public int value() {
        return this.value;
    }
    
 
    public String description() {
        return this.description;
    }
}