package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static final Map<Integer, User> users = new HashMap<>();

    public static void addNewUser(User newUser) {
        users.put(newUser.getId(), newUser);
    }




}
