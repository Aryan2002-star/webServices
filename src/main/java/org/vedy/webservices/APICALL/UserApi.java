package org.vedy.webservices.APICALL;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.vedy.webservices.socialMedia.UserDAO;
import org.vedy.webservices.socialMedia.User;

import java.net.URI;
import java.util.List;


@RestController
public class UserApi {
    private final UserDAO userlist;

    public UserApi(UserDAO userlist) {
        this.userlist = userlist;
    }


    @GetMapping("/users")
    public List<User> retrieve(){
        return userlist.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieveOne(@PathVariable int id){
        return userlist.findOne(id);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userlist.deleteUser(id);
    }

    //This is used to save a user
    @PostMapping("/users")
        public ResponseEntity<User> save(@Valid @RequestBody User user){
        User savedUser = userlist.saveuser(user);

            //Now to get which user is added we need one more function
        //Suppose the created user in needed by the API user then we return it in location variable as

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()// This is to get the current path of the API
                .path("/{id}") // This is to add a new Path to the api
                .buildAndExpand(savedUser.getId()) //this is to add the {id} by getting the ID from the input user
                .toUri(); // and this is to send it to URI

            //This return will return the STATUS of 201 which means created in HTTP
            return ResponseEntity.created(location).build();

    }
}
