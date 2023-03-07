package com.mpokket.service;

import com.mpokket.model.UserDetails;
import com.mpokket.repository.UserPhoneBookRepository;
import org.junit.Before;
import org.junit.Test;


import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


public class UserPhoneServiceTest {

    private UserPhoneService userPhoneServiceUnderTest;

    @Before
    public void setUp() {
        userPhoneServiceUnderTest = new UserPhoneService();
        userPhoneServiceUnderTest.userPhoneBookRepository = mock(UserPhoneBookRepository.class);
    }

    @Test
    public void testGetAllContacts() {
        // Setup
        // Configure UserPhoneBookRepository.findAll(...).
        final UserDetails userDetails1 = new UserDetails();
        final List<UserDetails> userDetails = Arrays.asList(userDetails1);
        when(userPhoneServiceUnderTest.getAllContacts()).thenReturn(userDetails);

        // Run the test
        final List<UserDetails> result = userPhoneServiceUnderTest.getAllContacts();

        // Verify the results
    }

    @Test
    public void testGetAllContacts_UserPhoneBookRepositoryReturnsNoItems() {
        // Setup
        when(userPhoneServiceUnderTest.getAllContacts()).thenReturn(Collections.emptyList());

        // Run the test
        final List<UserDetails> result = userPhoneServiceUnderTest.getAllContacts();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testGetContactsById() {

        final UserDetails userDetails1 = new UserDetails();
        final Optional<UserDetails> userDetails = Optional.of(userDetails1);
        when(userPhoneServiceUnderTest.getContactsById(0)).thenReturn(userDetails.get());

        // Run the test
        final UserDetails result = userPhoneServiceUnderTest.getContactsById(0);

        // Verify the results
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetContactsById_UserPhoneBookRepositoryReturnsAbsent() {
        // Setup
        when(userPhoneServiceUnderTest.getContactsById(0)).thenReturn(new UserDetails());

        // Run the test
        userPhoneServiceUnderTest.getContactsById(0);
    }

    @Test
    public void testSaveOrUpdate() {
        // Setup
        final UserDetails userDetails = new UserDetails();

        // Configure UserPhoneBookRepository.save(...).
        final UserDetails userDetails1 = new UserDetails();


        // Run the test
        userPhoneServiceUnderTest.saveOrUpdate(userDetails);

        // Verify the results
        verify(userPhoneServiceUnderTest).saveOrUpdate(any(UserDetails.class));
    }

    @Test
    public void testDelete() {
        // Setup
        // Run the test
        userPhoneServiceUnderTest.delete(0);

        // Verify the results
        verify(userPhoneServiceUnderTest).delete(0);
    }

}
