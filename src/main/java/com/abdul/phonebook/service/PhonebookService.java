package com.abdul.phonebook.service;

import com.abdul.phonebook.model.Phonebook;

import java.util.Collection;
import java.util.List;

public interface PhonebookService {
    Phonebook create(Phonebook phonebook);
    Collection<Phonebook> list(int limit);
    Phonebook get(Long id);
    Phonebook update(Phonebook phonebook);
    Boolean delete(Long id);






    // serach contacts
    //select multiple contacts and delete

}
