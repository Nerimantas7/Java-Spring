package lt.techin.ketvirtasblynas.controller;

import lt.techin.ketvirtasblynas.dto.UserCreationDTO;
import lt.techin.ketvirtasblynas.model.User;
import lt.techin.ketvirtasblynas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody UserCreationDTO userCreationDTO){
        System.out.println(userCreationDTO);
        User user = new User();
        if( userCreationDTO.getEmail() == null){
            throw new IllegalArgumentException();
        }
        if(!users.contains(userCreationDTO)) {
            user.setUserName(userCreationDTO.getUserName());
            user.setFirstName(userCreationDTO.getFirstName());
            user.setLastName(userCreationDTO.getLastName());
            user.setEmail(userCreationDTO.getEmail());
            users.add(user);
        }

        System.out.println("User: " + user);
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        System.out.println("Id: " + id);
        return users.stream().filter(u -> u.getId().equals(id)).findAny().orElseThrow();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
//        users.removeIf(user -> user.getId().equals(id));
//        users.remove(users.stream().filter(u -> u.getId().equals(id)).findAny().orElseThrow());
        users.removeIf(u -> u.getId().equals(id));
        System.out.println("Deleting user with Id: " + id);
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
//        users.stream().filter(u -> u.getId().equals(id)).map(u -> {u.setUserName(user.getUserName()), u.setFirstName(user.getFirstName()), u.setLastName(user.getLastName()), u.setEmail(user.getEmail()); return u;}).collect(Collectors.toList());
        for ( User addedUser : users) {
            if(addedUser.getId().equals(id)){
                addedUser.setUserName(user.getUserName());
                addedUser.setFirstName(user.getFirstName());
                addedUser.setLastName(user.getLastName());
                addedUser.setEmail(user.getEmail());
            }
        }

        System.out.println("Updating user with Id: " + id);
        return user;
    }
}

