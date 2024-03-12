package lt.techin.ketvirtasblynas.services;

import lt.techin.ketvirtasblynas.model.User;
import lt.techin.ketvirtasblynas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImplementation implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("Visų vartotojų sąrašas");
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        System.out.println("Sukuriamas naujas vartotojas");
        return userRepository.save(user);
    }
}
