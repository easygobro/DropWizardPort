package com.mvc.db;

import com.mvc.api.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class UserDB {
    private static Map<Integer, User> Users = new HashMap<Integer, User>();

    static {
        Users.put(1, new User(1, "FN1", "LN1", "email1@email.com"));
        Users.put(2, new User(2, "FN2", "LN2", "email2@email.com"));
        Users.put(3, new User(3, "FN3", "LN3", "email3@email.com"));
        Users.put(4, new User(4, "FN4", "LN4", "email4@email.com"));
    }

    public static User getById(int id) {
        return Users.get(id);
    }

    public static List<User> getAll() {
        List<User> result = new ArrayList<User>();
        for (Integer key : Users.keySet()) {
            result.add(Users.get(key));
        }
        return result;
    }

    public static int getCount() {
        return Users.size();
    }

    public static void remove() {
        if (!Users.keySet().isEmpty()) {
            Users.remove(Users.keySet().toArray()[0]);
        }
    }

    public static String save(User User) {
        String result = "";
        if (Users.get(User.getId()) != null) {
            result = "Updated User with id=" + User.getId();
        } else {
            result = "Added User with id=" + User.getId();
        }
        Users.put(User.getId(), User);
        return result;
    }
}
