package lt.techin.ketvirtasblynas.services;

import lt.techin.ketvirtasblynas.model.User;

import java.util.List;

public interface UserService {

    default List<User> getAllUsers() {
        return null;
    }

    default User createUser(User user) {
        return null;
    }
}
