package com.xfactor.openlibrary.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.Domain.Author;

public interface AuthorRepositories extends JpaRepository<Author,Long>{
    List<Author> findByName(String name);
    List<Author> findByBirthDate(String birthDate);
    List<Author> findByNationality(String nationality);    
}

