package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto account);
	AccountDto getAccountById(long id);
	AccountDto deposit(long id, double amount);
	AccountDto withdraw(long id, double amount);
	List<AccountDto> getAllAccount();
	void deleteAccount(long id);
}
