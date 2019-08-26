package br.com.teste.south.contaservice.service;

import br.com.teste.south.contaservice.domain.Account;
import br.com.teste.south.contaservice.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService {

    private AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public Account save(Account account)
    {
        account.setDataCriacao(LocalDate.now());
        return repo.save(account);
    }

    public Page<Account> findAll(Integer page, Integer linesPerPage, String orderBy, String direction)
    {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Account findById(String id)
    {
        return repo.findById(id).orElse(null);
    }

    public Account update(String id, Account updatedAccount)
    {
        Account account = findById(id);
        account.setNumero(updatedAccount.getNumero());
        account.setAgencia(updatedAccount.getAgencia());
        account.setCpf(updatedAccount.getCpf());
        account.setStatus(updatedAccount.isStatus());
        account.setDataAtualizacao(LocalDate.now());
        return this.save(account);
    }

    public Account delete(String id)
    {
        Account account = findById(id);
        account.setStatus(false);
        account.setDataAtualizacao(LocalDate.now());
        return this.save(account);
    }

    public List<Account> findByStatus(boolean status)
    {
        return repo.findByStatus(status);
    }
}
