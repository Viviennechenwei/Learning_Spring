package com.springlearning.dao.impl;

import com.springlearning.dao.IAccountDao;
import com.springlearning.entity.Account;
import com.springlearning.utils.ConnectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //保存
    public void saveAccount(Account account){
        PreparedStatement pstmt = null;
        String saveSql = "insert into accounts(id, name, money) value(?,?,?)";
        try {
            pstmt = connectionUtils.getConnection().prepareStatement(saveSql);
            pstmt.setInt(1, account.getId());
            pstmt.setString(2, account.getName());
            pstmt.setFloat(3, account.getMoney());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //删除
    public void deleteAccount(int id){
        PreparedStatement pstmt = null;
        String deleteSql = "delete from accounts where id = ?";
        try {
            pstmt = connectionUtils.getConnection().prepareStatement(deleteSql);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //更新
    public void updateAccount(Account account){
        PreparedStatement pstmt = null;
        String updateSql = "update accounts set money = ? where id = ?";
        try {
            pstmt = connectionUtils.getConnection().prepareStatement(updateSql);
            pstmt.setFloat(1, account.getMoney());
            pstmt.setInt(2, account.getId());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //查询多个
    public List<Account> searchAccounts(float money){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Account> accountList = new ArrayList<Account>();
        String serchAccountsSql = "select * from accounts where money > ?";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        try {
            pstmt = connectionUtils.getConnection().prepareStatement(serchAccountsSql);
            pstmt.setFloat(1, money);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setName(rs.getString(2));
                account.setMoney(rs.getFloat(3));
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }


    //查询一个
    public Account searchAccountByName(String name){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Account account = new Account();
        String searchAccountByName = "select * from accounts where name = ?";
        try {
            pstmt = connectionUtils.getConnection().prepareStatement(searchAccountByName);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if(rs.next()){
                account.setId(rs.getInt(1));
                account.setName(rs.getString(2));
                account.setMoney(rs.getFloat(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    //查询一行或一列
    public Integer serchCount(float money){
        PreparedStatement pstmt = null;
        int count = 0;
        String searchCount = "select count(*) from accounts where money > ?";
        try {
            pstmt = connectionUtils.getConnection().prepareStatement(searchCount);
            pstmt.setFloat(1, money);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public void transfer(String sourceName, String targetName, float money){
        Account source = searchAccountByName(sourceName);
        Account target = searchAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        updateAccount(source);
//         int i = 1/0;
        updateAccount(target);
    }

}