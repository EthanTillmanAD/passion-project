package com.Pasionproject.PasionProject.enums;

public enum BigSize {

    SMALL("256GB"), MED("512GB"), LARGE("1024GB"), MAX("2048GB"), SUPER("4096GB") ;


    private final String type;

    BigSize(String type){

        this.type = type;
    }

    public String getType(){
        return type;
    }
}
