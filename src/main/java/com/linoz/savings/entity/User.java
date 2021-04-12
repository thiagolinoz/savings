package com.linoz.savings.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by linoz on 2/4/21
 */
@Entity
@Getter
@NoArgsConstructor //JPA Only
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @NotNull
    @Column(unique = true)
    private String email;
    private Long cellphone;

    public User(String name, String email, Long cellphone) {
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
    }

    public static User builder() {
        return new User();
    }

    public User id(long id) {
        this.id = id;
        return this;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User cellphone(Long cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public User build() {
        return new User(id, name, email, cellphone);
    }

}
