package ru.clevertec.repositories;


import java.util.Optional;

public interface UserRepository<T> {
    void createUser(T user);

    Optional<T> getUser(String secondName);

}
