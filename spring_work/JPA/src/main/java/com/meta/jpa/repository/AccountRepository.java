package com.meta.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meta.jpa.dto.Account;
import com.meta.jpa.model.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity ,String>{

}
