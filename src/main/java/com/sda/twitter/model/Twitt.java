package com.sda.twitter.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Twitt {

    private Long id;
    private User user;
    private String message;
    private Long date;

}
