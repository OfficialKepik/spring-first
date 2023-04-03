package org.itstep;

import java.util.ArrayList;
import java.util.List;

//Databases
public class UserRepoOld {

    List<User> users = new ArrayList<>() {{
        add(new User(1L, "admin", "admin", "admin@mail.ru"));
        add(new User(2L, "user1", "user1", "user1@mail.ru"));
        add(new User(3L, "user3", "user3", "user3@mail.ru"));
    }};

    public List<User> getUsers() {
        return users;
    }

    public User getUser(long id){
        User result = users.stream()
                        .filter(user->user.getId()==id)
                        .findFirst()
                        .orElse(null);
        return result;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void changeUser(long id, User userNew){
        User userOld = users.stream()
                        .filter(u->u.getId()==id)
                        .findFirst()
                        .orElse(null);
        userOld.setUsername(userNew.getUsername());
        userOld.setPassword(userNew.getPassword());
        userOld.setEmail(userNew.getEmail());
    }

    public void deleteUser(long id){
        User userOld = users.stream()
                .filter(user->user.getId()==id)
                .findFirst()
                .orElse(null);
        users.remove(userOld);
    }
}
