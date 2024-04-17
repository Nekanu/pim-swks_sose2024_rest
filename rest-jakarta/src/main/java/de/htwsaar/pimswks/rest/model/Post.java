package de.htwsaar.pimswks.rest.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long postId;

    @Length(min = 3)
    @Column(name = "title")
    public String title;

    @Column(name = "content")
    public String content;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    public User author;
}
