package com.designi.desiginibackend.impl.service.auth;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/auth")
public class AuthenticationController {
private final AuthenticationService Authservice;

    public AuthenticationController(AuthenticationService authservice) {
        Authservice = authservice;
    }


    @GetMapping("/version")
    public ResponseEntity<String> getVersion(){

        return ResponseEntity.ok("designi app server version V0.0.1");
    }



    @RequestMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerAsNewUser(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(Authservice.register(request));
    }


    @RequestMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(Authservice.authenticate(request));
    }
}
