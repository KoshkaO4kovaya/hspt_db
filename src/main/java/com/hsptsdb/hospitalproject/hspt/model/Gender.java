package com.hsptsdb.hospitalproject.hspt.model;

public enum Gender {
    WOMAN ("Женщина"),
    MAN ("Мужчина")
    private final String genderTextDisplay;

    Gender(String genderTextDisplay) {
        this.genderTextDisplay = genderTextDisplay;
    }

    public String getGenderTextDisplayenderTextDisplay(){return genderTextDisplay;}
}
