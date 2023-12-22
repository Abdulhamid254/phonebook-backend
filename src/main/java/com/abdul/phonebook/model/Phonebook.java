package com.abdul.phonebook.model;

import com.abdul.phonebook.enumeration.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phonebook {
    // id will be incharge of our pk in database
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NotEmpty(message = "Email Address cannot be empty or null")
    private String  email;
    private String phoneNumber;
    private String address;
    private String username;

//    private Gender gender;
}
