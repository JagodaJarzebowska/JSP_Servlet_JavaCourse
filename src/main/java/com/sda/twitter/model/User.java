package com.sda.twitter.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Long id;
    private String nick;
    private String email;
    private String password;
}
