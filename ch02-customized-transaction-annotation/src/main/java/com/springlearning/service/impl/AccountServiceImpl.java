package com.springlearning.service.impl;

import com.springlearning.dao.IAccountDao;
import com.springlearning.entity.Account;
import com.springlearning.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountDao accountDao;

    public void saveAccount(Account account) throws SQLException {
        accountDao.saveAccount(account);
    }

    public void deleteAccount(int id)  throws SQLException {
        accountDao.deleteAccount(id);
    }

    public void updateAccount(Account account)  throws SQLException {
        accountDao.updateAccount(account);
    }

    public List<Account> searchAccounts(float money) throws SQLException  {
        return accountDao.searchAccounts(money);
    }

    public Account searchAccountByName(String name) throws SQLException  {
        return accountDao.searchAccountByName(name);
    }

    public Integer serchCount(float money)  throws SQLException {
        return accountDao.serchCount(money);
    }

    public void transfer(String sourceName, String targetName, float money)  throws SQLException {
        accountDao.transfer(sourceName, targetName, money);
    }
}
