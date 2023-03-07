package com.mpokket.repository;

import com.mpokket.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPhoneBookRepository extends JpaRepository<UserDetails, Integer> {


}
