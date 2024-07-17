package com.Nahudev.application_blog_api_rest.model;

import jakarta.persistence.*;
import jdk.jfr.ContentType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tokens")
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String accesToken;

    private String tokenType;

    private boolean expired;

    private boolean revoked;

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private UserEntity userEntity;

}
