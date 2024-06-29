package com.aash.SecondSpring.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService cs;

    public CompanyController(CompanyService cs) {
        this.cs = cs;
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(cs.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Company> findCompanyById(@PathVariable Long id){
        Company company = cs.findCompanyById(id);

        if(company!=null) return new ResponseEntity<>(company, HttpStatus.OK );

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> listCompany(@RequestBody Company company){
        cs.listCompany(company);

        return new ResponseEntity<>("Company Listed Successfully!", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean deleted = cs.deleteCompany(id);

        if(deleted) return new ResponseEntity<>("Company deleted!", HttpStatus.OK);

        return new ResponseEntity<>("Company Not Found!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company params){
        boolean updated = cs.updateCompany(id, params);

        if(updated) return new ResponseEntity<>("Company Updated!", HttpStatus.OK);

        return new ResponseEntity<>("Company Not Found!", HttpStatus.NOT_FOUND);
    }
}
