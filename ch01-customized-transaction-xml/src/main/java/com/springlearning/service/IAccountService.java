package com.springlearning.service;

import com.springlearning.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService {
    public void saveAccount(Account account) throws SQLException;

    public void deleteAccount(int id) throws SQLException;

    public void updateAccount(Account account) throws SQLException;

    public List<Account> searchAccounts(float money) throws SQLException;

    public Account searchAccountByName(String name) throws SQLException;

    public Integer serchCount(float money) throws SQLException;

    public void transfer(String sourceName, String targetName, float money) throws SQLException;
}
