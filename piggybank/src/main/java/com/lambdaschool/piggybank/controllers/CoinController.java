package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        List<Coin> myList = new ArrayList<>();
        coinrepo.findAll().iterator().forEachRemaining(myList::add);

        double sum = 0;
        for(Coin currentCoin : myList)
        {
            sum += currentCoin.getQuantity() * currentCoin.getValue();

            if(currentCoin.getQuantity() > 1)
            {
                System.out.println(currentCoin.getQuantity() + " " + currentCoin.getNameplural());
            }
            else
            {
                System.out.println(currentCoin.getQuantity() + " " + currentCoin.getName());
            }
        }

        System.out.println("The piggy bank holds " + sum);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
