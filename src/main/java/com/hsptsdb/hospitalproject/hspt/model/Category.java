package com.hsptsdb.hospitalproject.hspt.model;

public enum Category {
    F_DIAGNOSTIC ("Фун. Диагностика"),
    UZI ("Узи"),
    INJECTION ("Инъекция"),
    NOVEL("Роман"),
    OTHER ("Прочее");

    private final String genreTextDisplay;

    Category(String genreTextDisplay) {
        this.genreTextDisplay = genreTextDisplay;
    }

    public String getGenreTextDisplay(){return genreTextDisplay;}
}

