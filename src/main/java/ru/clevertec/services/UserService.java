package ru.clevertec.services;

public interface UserService<T> {
    void createUser(T user);

    T getUser(String secondName);
}
