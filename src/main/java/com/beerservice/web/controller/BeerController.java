package com.beerservice.web.controller;

import com.beerservice.MsscBeerServiceApplication;
import com.beerservice.services.BeerService;
import com.beerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

import static com.beerservice.web.constant.WebConstants.BEER_ENDPOINT;

@RequiredArgsConstructor
@RestController
@RequestMapping(BEER_ENDPOINT)
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable UUID beerId, @Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.OK);
    }
}
