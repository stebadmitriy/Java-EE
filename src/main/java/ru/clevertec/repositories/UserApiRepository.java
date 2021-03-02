package ru.clevertec.repositories;


import ru.clevertec.entities.User;

import java.util.List;
import java.util.Optional;

public class UserApiRepository implements UserRepository<User> {
    private static List<User> users;

    public UserApiRepository(List<User> users) {
        UserApiRepository.users = users;
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public Optional<User> getUser(String secondName) {
        return users
                .stream()
                .filter(user -> user.getSecondName().equals(secondName))
                .findFirst();

    }

    public static List<User> getUsers() {
        return users;
    }
}
