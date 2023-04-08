package com.xfactor.openlibrary.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.xfactor.openlibrary.Domain.Author;
import com.xfactor.openlibrary.Repositories.AuthorRepositories;

@RestController
@RequestMapping("authors")
public class AuthorController {
    //ArrayList<Author> Lauthors = new ArrayList<>();
    private AuthorRepositories authorRepositories;
    public AuthorController(AuthorRepositories authorRepositories){
        this.authorRepositories = authorRepositories;
    }

    @PostMapping("/saveauthor")
    public Author saveAuthor(@RequestBody Author author)
    {
        //Lauthors.add(author);
        authorRepositories.save(author);
        return author;
    }

    @GetMapping("/getAll")
    public List<Author> getAllAuthors()
    {
        return authorRepositories.findAll();
        //return Lauthors;
    }

    @PutMapping("/updateauthor")
    public Author updateAuthor(@RequestBody Author author, CrudRepository<Author, Long> authorRepository){
        if(author.getId() != null){
            Author author2 = authorRepository.save(author);
            return author2;
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorRepositories.deleteById(id);
    }

    @GetMapping("findTotal")
    public Long findTotal() {
        return authorRepositories.count();
    }

    @GetMapping("findById/{id}")
    public Author findById(@PathVariable Long id) {
        Optional<Author> optionalOfAuthor = authorRepositories.findById(id);
        if (optionalOfAuthor.isPresent()){
            return optionalOfAuthor.get();
        }
        return null;
    }

    @GetMapping("findByName/{name}")
    public List<Author> findByName(@PathVariable String name){
        List<Author> listOfName = authorRepositories.findByName(name);
        return listOfName;
    }

    @GetMapping("findByBirthDate/{birthDate}")
    public List<Author> findByBirthDate(@PathVariable String birthDate){
        List<Author> listOfBirthDate = authorRepositories.findByBirthDate(birthDate);
        return listOfBirthDate;
    }

    @GetMapping("findByNationality/{nationality}")
    public List<Author> findByNationality(@PathVariable String nationality){
        List<Author> listOfNationality = authorRepositories.findByNationality(nationality);
        return listOfNationality;
    }

}
