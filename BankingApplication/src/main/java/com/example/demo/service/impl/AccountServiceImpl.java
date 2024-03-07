package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount= accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
		
	}

	@Override
	public AccountDto getAccountById(long id) {
		Account account=accountRepository.findById(id).orElseThrow(
				()->new RuntimeException("Accounts doesn't exist! "));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(long id, double amount) {
		Account account=accountRepository.findById(id).orElseThrow(
				()->new RuntimeException("Accounts doesn't exist! "));
		double total=account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(long id, double amount) {
		Account account=accountRepository.findById(id).orElseThrow(
				()->new RuntimeException("Accounts doesn't exist! "));
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient");
		}
		double total=account.getBalance()-amount;
		account.setBalance(total);
		Account saved=accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(saved);
	}

	@Override
	public List<AccountDto> getAllAccount() {
		List<Account> accounts=accountRepository.findAll();
		return accounts.stream().map((account)-> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(long id) {
		Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Accounts not available! "));
		accountRepository.deleteById(id);
		
	}

}
