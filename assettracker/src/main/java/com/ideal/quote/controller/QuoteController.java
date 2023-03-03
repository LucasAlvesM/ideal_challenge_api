package com.ideal.quote.controller;

import com.ideal.quote.domain.quote.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("quotes")
public class QuoteController {

    @Autowired
    private QuoteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register( @RequestBody @Valid DadosQuoteRegister dados, UriComponentsBuilder uriBuilder) {
        var quote = new Quote (dados);
        repository.save(new Quote (dados));

        var uri = uriBuilder.path("/quotes/{id}").buildAndExpand(quote.getId()).toUri ();
        return ResponseEntity.created(uri).body (new DadosQuoteDetails (quote));
    }

    @GetMapping
    public ResponseEntity<Page< DadosWatchlist >> list( @PageableDefault(size = 10, sort = {"symbol"}) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(DadosWatchlist::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosQuoteUpdate dados) {
        var quote = repository.getReferenceById(dados.id());
        quote.updateInformation (dados);
        return ResponseEntity.ok(new DadosQuoteDetails(quote));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete( @PathVariable Long id) {
        var quote = repository.getReferenceById(id);
        quote.delete();

        return ResponseEntity.noContent ().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detail( @PathVariable Long id) {
        var quote = repository.getReferenceById(id);
        return ResponseEntity.ok (new DadosQuoteDetails(quote));
    }


}
