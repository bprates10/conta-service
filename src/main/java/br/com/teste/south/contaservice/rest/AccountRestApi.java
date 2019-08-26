package br.com.teste.south.contaservice.rest;

import br.com.teste.south.contaservice.domain.Account;
import br.com.teste.south.contaservice.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping(value = "/Account")
@RestController
public class AccountRestApi {

    private AccountService service;

    public AccountRestApi(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Account account)
    {
        Account acc = service.save(account);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(acc.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<Account>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "linesPerPage", defaultValue = "3") Integer linesPerPage,
                                                 @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
                                                 @RequestParam(value = "direction", defaultValue = "ASC") String direction)
    {
        return ResponseEntity.ok().body(service.findAll(page, linesPerPage, orderBy, direction));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> findById(@PathVariable String id)
    {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Account> update(@RequestBody Account account, @PathVariable String id)
    {
        return ResponseEntity.ok().body(service.update(id, account));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/status/{status}")
    public ResponseEntity<List<Account>> findByStatus(@PathVariable boolean status)
    {
        return ResponseEntity.ok().body(service.findByStatus(status));
    }
}
