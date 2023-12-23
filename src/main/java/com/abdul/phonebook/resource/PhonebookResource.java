package com.abdul.phonebook.resource;

import com.abdul.phonebook.model.Phonebook;
import com.abdul.phonebook.model.Response;
import com.abdul.phonebook.service.implementation.PhonebookServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.WebResourceRoot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/contact") //base path url
@RequiredArgsConstructor // annotation that brings about dependency injection using lombok

public class PhonebookResource {
    private final PhonebookServiceImpl PhonebookService;


    @GetMapping("/list")
    public ResponseEntity<Response> getServers() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        WebResourceRoot phonebookService;
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        // below you can also ask for a parameter from the user bt here the 30 limit we have just hardcoded it
                        .data(of("contacts", PhonebookService.list(30)))
                        .message("Contacts retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }



    @PostMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Phonebook phonebook) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("contact", PhonebookService.create(phonebook)))
                        .message("contact created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPhonebook(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("contact", PhonebookService.get(id)))
                        .message("contact retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePhonebook(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("deleted", PhonebookService.delete(id)))
                        .message("Contact deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updatePhonebook(
            @PathVariable("id") Long id,
            @RequestBody @Valid Phonebook updatedPhonebook
    ) {
        Phonebook existingPhonebook = PhonebookService.get(id);

        if (existingPhonebook != null) {
            updatedPhonebook.setId(id); // Make sure the ID from the path is set in the updated Phonebook

            Phonebook updatedContact = PhonebookService.update(updatedPhonebook);

            if (updatedContact != null) {
                return ResponseEntity.ok(
                        Response.builder()
                                .timestamp(now())
                                .data(of("contact", updatedContact))
                                .message("Contact updated")
                                .status(OK)
                                .statusCode(OK.value())
                                .build()
                );
            } else {
                // Handle the case where the update failed
                return ResponseEntity.status(500).build(); // Internal Server Error
            }
        } else {
            // Handle the case where the contact with the provided ID is not found
            return ResponseEntity.status(404).build(); // Not Found
        }
    }


}
