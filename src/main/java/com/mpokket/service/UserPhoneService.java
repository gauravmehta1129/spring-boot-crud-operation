package com.mpokket.service;

import com.mpokket.model.PhoneNumber;
import com.mpokket.model.UserDetails;
import com.mpokket.repository.UserPhoneBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserPhoneService {
    @Autowired
    UserPhoneBookRepository userPhoneBookRepository;

    //getting all contacts
    public List<UserDetails> getAllContacts() {
        final List<UserDetails> userDetails = new ArrayList<UserDetails>();
        userPhoneBookRepository.findAll().forEach(contact -> userDetails.add(contact));
        return userDetails;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public UserDetails getContactsById(final Integer id) {
        return userPhoneBookRepository.findById(id).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void  saveOrUpdate(final UserDetails userDetails) {
        final PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setUserDetails(userDetails);
        phoneNumber.setPhoneNumber(userDetails.getPhoneNumbers().stream().findAny().get().getPhoneNumber());
        phoneNumber.setType(userDetails.getPhoneNumbers().stream().findAny().get().getType());
        userDetails.setPhoneNumbers(Collections.singleton(phoneNumber));
        userPhoneBookRepository.save(userDetails);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Integer id) {
        userPhoneBookRepository.deleteById(id);
    }

    //updating a phone contact
    public void update(final UserDetails userDetails, final Integer contactId) {
        final Optional<UserDetails> fetchedUserDetails = userPhoneBookRepository.findById(contactId);
        if(fetchedUserDetails.isPresent()){
            fetchedUserDetails.get().setFirstName(userDetails.getFirstName());
            fetchedUserDetails.get().setLastName(userDetails.getLastName());
            fetchedUserDetails.get().setPhoneNumbers(userDetails.getPhoneNumbers());
            userPhoneBookRepository.save(fetchedUserDetails.get());
        }
    }
}
