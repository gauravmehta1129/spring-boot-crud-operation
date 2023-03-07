package com.mpokket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "user_details")
@Entity
@Getter
@Setter
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    @OneToMany(mappedBy = "userDetails",cascade = CascadeType.ALL)
    private Set<PhoneNumber> phoneNumbers;

}
