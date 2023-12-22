package com.abdul.phonebook.service.implementation;

import com.abdul.phonebook.model.Phonebook;
import com.abdul.phonebook.repo.PhonebookRepo;
import com.abdul.phonebook.service.PhonebookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j

public class PhonebookServiceImpl implements PhonebookService {
    private final PhonebookRepo phonebookRepo;
    @Override
    public Phonebook create(Phonebook phonebook) {
        log.info("Saving new contact: {}",phonebook.getFirstName());
//        phonebook.setImageUrl(setPhonebookImageUrl());
        return phonebookRepo.save(phonebook);
    }

    @Override
    public Collection<Phonebook> list(int limit) {
        log.info("Fetching all contacts");
        // find All method here returns a page bt we want a collection that's why we use The toList(0 fxn to give us a list/collection
        return phonebookRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Phonebook get(Long id) {
        log.info("Fetching contact by id:{}", id);
        return phonebookRepo.findById(id).get();
    }

    @Override
    public Phonebook update(Phonebook phonebook) {
        log.info("Updating contact: {]", phonebook.getUsername());
        return phonebookRepo.save(phonebook);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting contact By id :{}", id);
        phonebookRepo.deleteById(id);
        return TRUE;
    }
}
