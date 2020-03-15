package com.springlearning.dao.impl;

import com.springlearning.dao.IAccountDao;
import com.springlearning.entity.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //保存
    public void saveAccount(Account account) {
        String saveSql = "insert into accounts(id, name, money) value(?,?,?)";
        jdbcTemplate.update(saveSql, account.getId(), account.getName(), account.getMoney());
    }

    //删除
    public void deleteAccount(int id) {
        String deleteSql = "delete from accounts where id = ?";
        jdbcTemplate.update(deleteSql, id);
    }

    //更新
    public void updateAccount(Account account) {
        String updateSql = "update accounts set money = ? where id = ?";
        jdbcTemplate.update(updateSql, account.getMoney(), account.getId());
    }

    //查询多个
    public List<Account> searchAccounts(float money) {
        String serchAccountsSql = "select * from accounts where money > ?";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        return jdbcTemplate.query(serchAccountsSql, rowMapper, money);
    }


    //查询一个
    public Account searchAccountByName(String name) {
        String searchAccountByName = "select * from accounts where name = ?";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        return jdbcTemplate.queryForObject(searchAccountByName, rowMapper, name);
    }

    //查询一行或一列
    public Integer serchCount(float money) {
        String searchCount = "select count(*) from accounts where money > ?";
        return jdbcTemplate.queryForObject(searchCount, Integer.TYPE, money);
    }

    public void transfer(String sourceName, String targetName, float money) {
        Account source = searchAccountByName(sourceName);
        Account target = searchAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        updateAccount(source);
         int i = 1/0;
        updateAccount(target);
    }

}