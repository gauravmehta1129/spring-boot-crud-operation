package com.mpokket.controller;

import com.mpokket.model.UserDetails;
import com.mpokket.service.UserPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserPhoneBookController {
    //autowire the BooksService class
    @Autowired
    UserPhoneService userPhoneService;

    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/allContacts")
    private List<UserDetails> getAllBooks() {
        return userPhoneService.getAllContacts();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/contact/{bookid}")
    private UserDetails getContactById(@PathVariable("bookid") final Integer bookid) {
        return userPhoneService.getContactsById(bookid);
    }

    //creating a delete mapping that deletes a specified contact
    @DeleteMapping("/contact/{contactId}")
    private void deleteContact(@PathVariable("contactId") final Integer contactId) {
        userPhoneService.delete(contactId);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/create-contact")
    private int createNewContact(@RequestBody final UserDetails userDetails) {
        userPhoneService.saveOrUpdate(userDetails);
        return userDetails.getId();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/update-contact/{contactId}")
    private UserDetails updateContact(@PathVariable("contactId") final Integer contactId, @RequestBody final UserDetails userDetails) {
        userPhoneService.update(userDetails, contactId);
        return userDetails;
    }
}
