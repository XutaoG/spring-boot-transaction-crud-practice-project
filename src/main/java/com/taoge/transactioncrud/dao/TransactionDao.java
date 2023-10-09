package com.taoge.transactioncrud.dao;

import com.taoge.transactioncrud.entity.Transaction;

import java.util.List;

public interface TransactionDao
{
	void save(Transaction transaction);

	Transaction findById(int id);

	List<Transaction> findAll();

	List<Transaction> findImportantTransactions();

	void update(Transaction transaction);

	Transaction deleteById(int id);

	int deleteAll();
}
