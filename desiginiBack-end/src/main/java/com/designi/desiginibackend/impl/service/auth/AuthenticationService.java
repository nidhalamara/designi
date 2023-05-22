package com.designi.desiginibackend.impl.service.auth;


import com.designi.desiginibackend.core.security.JwtService;
import com.designi.desiginibackend.impl.dal.UserRepository;
import com.designi.desiginibackend.impl.entity.User;
import com.designi.desiginibackend.impl.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
private final UserRepository repository;
private final PasswordEncoder passwordEncoder;
private final JwtService jwtService;
private final AuthenticationManager authenticationManager;



    public AuthenticationResponse register(RegisterRequest request) {
        var user= User.builder().
                firstName(request.getFirstName()).lastName(request.getLastName()).email(request.getEmail()).profileImage(request.getImageData())
                        .password( passwordEncoder.encode( request.getPassword())).
        role(Role.USER).  build();
        repository.save(user);
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
   authenticationManager.authenticate(
           new UsernamePasswordAuthenticationToken(
                   request.getEmail(),request.getPassword()
           )
   );
   var user=repository.findUserByEmail(request.getEmail()).orElseThrow(
           //todo handle the right exception and not make it general for the UX

   );
        var jwtToken= jwtService.generateToken(user);
   return AuthenticationResponse.builder().token(jwtToken).firstName(user.getFirstName()).lastName(user.getLastName()).imageData(user.getProfileImage()).build();



    }
}
