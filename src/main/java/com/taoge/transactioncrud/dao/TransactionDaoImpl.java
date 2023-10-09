package com.taoge.transactioncrud.dao;

import com.taoge.transactioncrud.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao
{
	private EntityManager entityManager;

	@Autowired
	public TransactionDaoImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Transaction transaction)
	{
		entityManager.persist(transaction);
	}

	@Override
	public Transaction findById(int id)
	{
		return entityManager.find(Transaction.class, id);
	}

	@Override
	public List<Transaction> findAll()
	{
		TypedQuery<Transaction> typedQuery = entityManager.createQuery("FROM Transaction", Transaction.class);

		return typedQuery.getResultList();
	}

	@Override
	public List<Transaction> findImportantTransactions() // importantTransaction: transaction amount >= 100
	{
		TypedQuery<Transaction> typedQuery = entityManager.createQuery("FROM Transaction WHERE amount >= 100", Transaction.class);

		return typedQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Transaction transaction)
	{
		entityManager.merge(transaction);
	}

	@Override
	@Transactional
	public Transaction deleteById(int id)
	{
		Transaction transaction = findById(id);
		entityManager.remove(transaction);
		return transaction;
	}

	@Override
	@Transactional
	public int deleteAll()
	{
		Query query = entityManager.createQuery("DELETE FROM Transaction");

		return query.executeUpdate();
	}
}
