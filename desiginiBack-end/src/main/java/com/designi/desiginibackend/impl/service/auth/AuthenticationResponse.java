package com.designi.desiginibackend.impl.service.auth;

import com.designi.desiginibackend.impl.model.ImageData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@Data@Builder @AllArgsConstructor @NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private byte[] imageData;
    private String firstName;
    private String lastName;


}
