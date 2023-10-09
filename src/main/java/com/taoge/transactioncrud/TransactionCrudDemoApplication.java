package com.taoge.transactioncrud;

import com.taoge.transactioncrud.dao.TransactionDao;
import com.taoge.transactioncrud.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TransactionCrudDemoApplication
{
	private TransactionDao transactionDao;

	public static void main(String[] args)
	{
		SpringApplication.run(TransactionCrudDemoApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner(TransactionDao transactionDao)
	{
		this.transactionDao = transactionDao;

		return runner ->
		{
			saveTransaction();
			System.out.println();

			saveMultipleTransaction();
			System.out.println();

			readTransaction(3);
			System.out.println();

			readAllTransactions();
			System.out.println();

			readImportantTransactions();
			System.out.println();

			updateTransaction();
			System.out.println();

			readAllTransactions();
			System.out.println();

			deleteTransactionById(1);
			System.out.println();

			deleteAllTransactions();
			System.out.println();

			readAllTransactions();
			System.out.println();
		};
	}

	public void saveTransaction()
	{
		System.out.println("***** Saving transaction *****");
		Transaction transaction = new Transaction("Peter", "Griffin", "Burger", 3.99);

		transactionDao.save(transaction);
		System.out.println("Saved transaction: " + transaction);
	}

	public void saveMultipleTransaction()
	{
		System.out.println("***** Saving 6 transactions *****");
		Transaction transaction1 = new Transaction("Lois", "Griffin", "Groceries", 28.56);
		Transaction transaction2 = new Transaction("Stewie", "Griffin", "Uranium", 12000.00);
		Transaction transaction3 = new Transaction("Brian", "Griffin", "Diamond Ring", 7000);
		Transaction transaction4 = new Transaction("Peter", "Griffin", "Car", 4999.99);
		Transaction transaction5 = new Transaction("Peter", "Griffin", "Beer", 19.99);
		Transaction transaction6 = new Transaction("Stewie", "Griffin", "Laser Gun", 1000.00);

		transactionDao.save(transaction1);
		transactionDao.save(transaction2);
		transactionDao.save(transaction3);
		transactionDao.save(transaction4);
		transactionDao.save(transaction5);
		transactionDao.save(transaction6);

		System.out.println("Saved transaction: " + transaction1);
		System.out.println("Saved transaction: " + transaction2);
		System.out.println("Saved transaction: " + transaction3);
		System.out.println("Saved transaction: " + transaction4);
		System.out.println("Saved transaction: " + transaction5);
		System.out.println("Saved transaction: " + transaction6);
	}

	public void readTransaction(int id)
	{
		System.out.println("***** Reading transaction with id: " + id + " *****");
		Transaction result = transactionDao.findById(id);

		if (result == null)
		{
			System.out.println("No transaction was found");
			return;
		}
		System.out.println("Found transaction: " + result);
	}

	public void readAllTransactions()
	{
		System.out.println("***** Reading all transactions *****");
		List<Transaction> result = transactionDao.findAll();


		if (result.isEmpty())
		{
			System.out.println("No transaction was found");
			return;
		}

		System.out.println("Found transaction: ");
		for (Transaction transaction : result)
		{
			System.out.println(transaction);
		}
	}

	public void readImportantTransactions()
	{
		System.out.println("***** Reading all important transaction *****");
		List<Transaction> result = transactionDao.findImportantTransactions();

		if (result.isEmpty())
		{
			System.out.println("No transaction was found");
			return;
		}

		System.out.println("Found transaction: ");
		for (Transaction transaction : result)
		{
			System.out.println(transaction);
		}
	}

	public void updateTransaction()
	{
		Transaction result = transactionDao.findById(1);

		System.out.println("***** Updating transaction with id: 1 *****");
		result.setAmount(5.99);

		transactionDao.update(result);
		System.out.println("Updated transaction: " + result);
	}

	public void deleteTransactionById(int id)
	{
		System.out.println("***** Deleting transaction with id: " + id + " *****");

		Transaction deletedTransaction = transactionDao.deleteById(id);

		System.out.println("Deleted transaction: " + deletedTransaction);
	}

	public void deleteAllTransactions()
	{
		System.out.println("***** Deleting all transactions *****");

		int numDeleted = transactionDao.deleteAll();

		System.out.println("Deleted " + numDeleted + " transactions");
	}
}
