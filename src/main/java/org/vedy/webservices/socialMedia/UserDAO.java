package org.vedy.webservices.socialMedia;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAO {
    private static List<User> usser = new ArrayList<>();
    private static int usercount = 0;

    static {
        usser.add(new User(++usercount,"Sachin Pal", LocalDate.now().minusYears(30)));
        usser.add( new User(++usercount,"Kanishka Jha", LocalDate.now().minusYears(20)));
        usser.add(new User(++usercount,"Ayush Sharma", LocalDate.now().minusYears(10)));
        usser.add(new User(++usercount,"Aditya Kumar", LocalDate.now().minusYears(50)));
//        usser.add(new User(++usercount,"KUMAR", LocalDate.now().minusYears(50)));
    }

    public List<User> findAll(){
        return usser;
    }
    public User findOne(int id){
        //Usage of Fuctional Programmingc
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return usser.stream().filter(predicate).findFirst().get();
    }

    public User saveuser(User user) {
        user.setId(++usercount);
        usser.add(user);
        return user;

    }

    public void deleteUser(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        usser.removeIf(predicate);
    }
}
