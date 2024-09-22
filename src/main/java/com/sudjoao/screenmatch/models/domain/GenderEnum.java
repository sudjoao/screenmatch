package com.sudjoao.screenmatch.models.domain;

public enum GenderEnum {
    ACTION("action"),
    COMEDY("comedy"),
    DRAMA("drama"),
    UNKNOWN("unkown");

    private final String name;


    GenderEnum(String name) {
        this.name = name;
    }

    public static GenderEnum getByName(String name) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.name().equals(name))
                return genderEnum;
        }
        throw new RuntimeException("Gender not found");
    }
}
