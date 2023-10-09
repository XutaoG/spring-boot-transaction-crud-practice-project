package com.taoge.transactioncrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction
{
	// ***** Fields *****

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_firstname")
	private String firstName;

	@Column(name = "customer_lastname")
	private String lastName;

	@Column(name = "transaction_title")
	private String title;

	@Column(name = "transaction_amount")
	private double amount;

	// ***** Constructor *****

	public Transaction()
	{

	}

	public Transaction(String firstName, String lastName, String title, double amount)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.amount = amount;
	}

	// ***** Getters/Setters *****

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	// ***** toString() *****

	@Override
	public String toString()
	{
		return "Transaction{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", title='" + title + '\'' +
				", amount=" + amount +
				'}';
	}
}
