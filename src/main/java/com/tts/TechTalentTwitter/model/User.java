package com.tts.TechTalentTwitter.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Long id;
    
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int active;
    
    @CreationTimestamp
    private Date createdAt;
    
    //Can't just store a set in a JPA entity---we are actually defining
    //a relationship between User and Role. This relationship will be
    //Many to Many in database terms.
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name= "user_role", joinColumns = @JoinColumn(name="user_id"),
               inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;
        
    //
    //public static void main(String[] args)
    //{
    //    User myUser = User.builder().active(1).email("sdossey@whatever.com").firstName("Scott").build();
    //}
}
