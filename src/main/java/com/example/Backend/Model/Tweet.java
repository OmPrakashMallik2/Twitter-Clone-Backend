package com.example.Backend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private String content;
    private String image;
    private String video;
    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private List<User> likes = new ArrayList<>();

    @OneToMany
    private List<Tweet> replyTweets = new ArrayList<>();

    @ManyToMany
    private List<User> retweetUsers = new ArrayList<>();

    @ManyToOne
    private Tweet replyFor;

    private boolean isReply;
    private boolean isTweet;
}
