package com.galan.springwebsocket.utility;


import com.github.javafaker.Faker;

public class DataFake {
    private static Faker FAKER = Faker.instance();

    public static Faker getFAKER() {
        return FAKER;
    }
}
