package com.hsptsdb.hospitalproject.hspt.model;

public enum Category {
    F_DIAGNOSTIC ("Фун. Диагностика"),
    UZI ("Узи"),
    INJECTION ("Инъекция"),
    NOVEL("Роман"),
    OTHER ("Прочее");

    private final String categoryTextDisplay;

    Category(String categoryTextDisplay) {
        this.categoryTextDisplay = categoryTextDisplay;
    }

    public String getCategoryTextDisplay(){return categoryTextDisplay;}
}

