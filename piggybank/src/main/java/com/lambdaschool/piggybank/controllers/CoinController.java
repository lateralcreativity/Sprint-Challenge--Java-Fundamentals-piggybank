package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinController
{
    @Autowired
    CoinRepository coinrepo;

    // http://localhost:2019/total
    // prints to console the contents of the Piggy Bank and returns an HTTP Status of OK
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> getTotal()
    {
        System.out.println("If connected will display in console");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
