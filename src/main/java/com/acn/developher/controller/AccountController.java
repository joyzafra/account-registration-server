package com.acn.developher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.developher.dao.AccountRepository;
import com.acn.developher.domain.Account;
import com.acn.developher.domain.Accounts;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepo;

	@GetMapping(path="/retrieve", produces = "application/json")
	public ResponseEntity<Accounts> getAccountRegistrations() {

		Accounts accountList = new Accounts();

		Iterable<Account> accounts = accountRepo.findAll();
		accounts.forEach(account -> {
			accountList.getAccountList().add(account);
		});
		return ResponseEntity.ok(accountList);

	}
	
	@PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Account> registerAccount(@RequestBody Account account) {

		return ResponseEntity.ok(accountRepo.save(account));

	}
}
