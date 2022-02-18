package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static final Map<Integer, User> users = new HashMap<>();

    public static void addNewUser(User newUser) {
        users.put(newUser.getId(), newUser);
    }

    public static User getById(Integer id) {
        return users.get(id);
    }

    public static Collection<User> getAll() {
        return users.values();
    }




}
