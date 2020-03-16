package com.springlearning.dao;

import com.springlearning.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao {

    public void saveAccount(Account account);

    public void deleteAccount(int id);

    public void updateAccount(Account account);

    public List<Account> searchAccounts(float money);
    public Account searchAccountByName(String name);
    public Integer serchCount(float money);

    public void transfer(String sourceName, String targetName, float money);
}
