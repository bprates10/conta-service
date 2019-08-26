package br.com.teste.south.contaservice.repository;

import br.com.teste.south.contaservice.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    public List<Account> findByStatus(boolean status);
}
