package com.decimate.site.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String username;

    private String email;

    private String password;
}
