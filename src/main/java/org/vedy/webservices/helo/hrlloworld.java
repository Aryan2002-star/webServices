package org.vedy.webservices.helo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class hrlloworld {

//    @RequestMapping(path="/hello-world",method = RequestMethod.GET) // Here we need to specify the method but if we dont want to specify method we use
    @GetMapping(path = "/hello") // Here its Automatically mapped to GET method (@PostMapping , @PutMapping)
    public String helloworld(){
        return "Hello Vedy";
    }

    // We return JSON data so we need to return a Bean in WebServices
    @GetMapping(path = "/hello-JSON")
    public hello helloJson(){
        return new hello("Aryan","GoodMorinig");
    }

    @GetMapping(path = "/hello-JSON-path/{user}")
    public hello helloJsonUser(@PathVariable String user){
        return new hello(user,"GoodMorinig");
    }
}
