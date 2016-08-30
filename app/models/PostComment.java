package models;
// PostComment.java

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;
import com.fasterxml.jackson.annotation.*;

@Entity
public class PostComment extends Model {

 @Id
 public Long id;

 @ManyToOne
 @JsonIgnore
 public BlogPost blogPost;

 @ManyToOne
 public User user;

 @Column(columnDefinition = "TEXT")
 public String content;

 public static final Finder<Long, PostComment> find = new Finder<Long, PostComment>(
     Long.class, PostComment.class);

 public static List<PostComment> findAllCommentsByPost(final BlogPost blogPost) {
   return find
       .where()
       .eq("post", blogPost)
       .findList();
 }

 public static List<PostComment> findAllCommentsByUser(final User user) {
   return find
       .where()
       .eq("user", user)
       .findList();
 }

}