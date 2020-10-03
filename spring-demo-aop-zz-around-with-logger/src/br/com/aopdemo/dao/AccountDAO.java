package br.com.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
	
	public List<Account> findAccounts() {
	
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account("John", "Silver"));
		accounts.add(new Account("Madhu", "Platinum"));
		accounts.add(new Account("Luca", "Gold"));
			
		return accounts;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public List<Account> findAccounts(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("No soup for you!!!");
		}
		
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account("John", "Silver"));
		accounts.add(new Account("Madhu", "Platinum"));
		accounts.add(new Account("Luca", "Gold"));
			
		return accounts;
	}
	
}
