package co.enlume.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.enlume.spring.model.Transactions;

@Transactional
public interface TransactionsDao extends JpaRepository<Transactions, Long> {
	
	List<Transactions> findByLastNameAndFirstName(String firstName, String lastName);
   	
}
