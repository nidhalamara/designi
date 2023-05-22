package com.designi.desiginibackend.impl.model;

import com.designi.desiginibackend.impl.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ImageData {
    @OneToOne
    private User user;

    private String name;
    private String type;

    private byte[] imageData;
}
