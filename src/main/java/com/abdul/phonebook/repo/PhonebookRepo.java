package com.abdul.phonebook.repo;

import com.abdul.phonebook.model.Phonebook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhonebookRepo extends JpaRepository<Phonebook, Long> {
    //since email is unique
    Phonebook findByEmail(String email);

}
