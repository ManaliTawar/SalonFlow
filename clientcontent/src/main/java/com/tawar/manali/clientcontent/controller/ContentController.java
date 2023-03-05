package com.tawar.manali.clientcontent.controller;

import com.tawar.manali.clientcontent.model.Content;
import com.tawar.manali.clientcontent.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/client/content")
@CrossOrigin
public class ContentController {
    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Content> findAll(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!"));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content,@PathVariable Integer id){

        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);

    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByName(@PathVariable String keyword){
        return repository.findAllByNameContains(keyword);
    }
    @GetMapping("/filter/name/{emailId}")
    public List<Content> findByEmailId(@PathVariable String emailId){
        return repository.listByEmailId(emailId);
    }

    @GetMapping("/filter/dob/{dob}")
    public List<Content> findByDOB(@PathVariable Date dob){
        return repository.findAllByDob(dob);
    }

}
