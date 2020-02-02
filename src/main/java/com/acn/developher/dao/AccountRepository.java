package com.acn.developher.dao;

import org.springframework.data.repository.CrudRepository;

import com.acn.developher.domain.Account;

public interface AccountRepository extends CrudRepository<Account, String>{

}
