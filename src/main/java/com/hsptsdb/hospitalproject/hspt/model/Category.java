package com.hsptsdb.hospitalproject.hspt.model;

public enum Category {
    FANTASY ("Фантастика"),
    SCIENCE_FICTION ("Научная фантастика"),
    DRAMA ("Драма"),
    NOVEL("Роман"),
    COMEDY("Комедия"),
    ADVENTURE ("Приключения");

    private final String genreTextDisplay;

    Category(String genreTextDisplay) {
        this.genreTextDisplay = genreTextDisplay;
    }

    public String getGenreTextDisplay(){return genreTextDisplay;}
}

