package com.mpokket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mpokket.constants.PhoneNumberType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name="phone_number")
@Entity
@Getter
@Setter
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String phoneNumber;
    @Column
    private PhoneNumberType type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private UserDetails userDetails;
}
