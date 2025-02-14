package com.tukorea.ns_baragi_server.likes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "likes")
public class Likes {
    @Id
    @Column(name = "code")
    private Long code;
    @Column(name = "likes")
    private Integer likes;
    @Column(name = "dislikes")
    private Integer dislikes;
}
