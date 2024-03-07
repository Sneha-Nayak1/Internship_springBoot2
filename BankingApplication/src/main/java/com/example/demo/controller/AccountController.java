package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Accounts deleted sucessfully");
		
	}
	@GetMapping("/{id}")
	
	public ResponseEntity<AccountDto> getById(@PathVariable long id){
		AccountDto accountDto=accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
//		return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable long id, @RequestBody Map<String,Double> m){
		double amount=m.get("amount");
		AccountDto accountDto=accountService.deposit(id,  amount);
		return  ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable long id, @RequestBody Map<String,Double> m){
		double amount=m.get("amount");
		AccountDto accountDto=accountService.withdraw(id, amount);
		return  ResponseEntity.ok(accountDto);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accounts=accountService.getAllAccount();
		return ResponseEntity.ok(accounts);
	}
	
	
}
