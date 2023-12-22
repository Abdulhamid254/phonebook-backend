package com.abdul.phonebook.enumeration;

public enum Gender {
    Male("MALE"),
    Female("FEMALE");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }


    public String getGender() {
        return this.gender;
    }
}
