package com.mkyong;

import com.mkyong.error.BookNotFoundException;
import com.mkyong.error.BookUnSupportedFieldPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    // Find
    @GetMapping("/books")
    List<Book> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/books")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    // Find
    @GetMapping("/books/{id}")
    Book findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    // Save or update
    @PutMapping("/books/{id}")
    Book saveOrUpdate(@RequestBody Book newBook, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setName(newBook.getName());
                    x.setAuthor(newBook.getAuthor());
                    x.setPrice(newBook.getPrice());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });
    }

    // update author only
    @PatchMapping("/books/{id}")
    Book patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String author = update.get("author");
                    if (!StringUtils.isEmpty(author)) {
                        x.setAuthor(author);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new BookUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new BookNotFoundException(id);
                });

    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
 // Save
    @PostMapping("/auth")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Token authenticateKeys(@RequestBody Auth auth) {
//       if(auth.clientID !== "CLIENTID-XXXXXX-555555-333333" || auth.secretkey !== "SECRRTKEY-XXXXXX-555555-333333") {
//    	   throw Exception("INVALID DETAILS");
//       }
       Token t = new Token();
       t.setToken("TOKEN:AHSKDHKASGDKASGKD_ASKDGAKSGDKAGSKDGKASGD");
       return t;
    }
    
    @GetMapping("/events")
    List<Events> getEvents() {
    	List<Events> lst = new ArrayList<Events>();
    	for (int i=1; i < 200; i++) {
    		Events e = new Events();
    		e.id = "" + i+1 * 100 * 3 * 2;
    		e.muid = "muid:"+ e.id;
    		e.machineName = "MachineName-" + (i % 15);
    		e.timeStamp = new Date().toLocaleString();
    		e.clientId = "CID-" + (i % 5);
    		e.clientName = "CNAME-" + (i % 5);
    		e.status = i % 4;
    		e.alertDateTime = e.timeStamp;
    		e.lastHourEvidenceCount = i % 20;
    		e.severity = i % 5;
    		e.mitre ="Execution-Mshta";
    		e.alertLink ="https:weawe";
    		lst.add(e);
    	}
        return lst;
    }


}
