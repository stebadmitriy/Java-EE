package ru.clevertec.services;




import ru.clevertec.entities.User;
import ru.clevertec.repositories.UserRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UserApiService implements UserService<User> {
    private final UserRepository<User> repository;

    public UserApiService(UserRepository<User> repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(User user) {
        repository.createUser(user);
    }

    @Override
    public User getUser(String secondName) {
        return Optional.ofNullable(repository.getUser(secondName))
                .orElseThrow(() ->
                        new NoSuchElementException("User with secondname " + secondName + " not exists"))
                .get();
    }
}
