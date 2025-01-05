package com.Pasionproject.PasionProject.enums;

public enum SmallSize {

    SMALL("4GB"), MED("8GB"), LARGE("16GB"), MAX("32GB") ;

    private final String type;

    SmallSize(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }




}
