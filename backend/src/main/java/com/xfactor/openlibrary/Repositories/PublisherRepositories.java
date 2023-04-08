package com.xfactor.openlibrary.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.Domain.Publisher;

import java.util.List;

public interface PublisherRepositories extends JpaRepository<Publisher, Long> {

    List<Publisher> findByname(String name);

    List<Publisher> findByaddress(String address);

    List<Publisher> findByphone(String phone);

    List<Publisher> findByemail(String email);
}
