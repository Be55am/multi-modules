package goldminds.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {


    @GetMapping("/private")
    public ResponseEntity<String> publicMethod(){
        return new ResponseEntity<String>("it works fine . ",HttpStatus.OK);

    }

}
