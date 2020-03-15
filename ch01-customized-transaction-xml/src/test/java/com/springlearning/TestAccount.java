package com.springlearning;

import com.springlearning.entity.Account;
import com.springlearning.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestAccount {

    @Autowired
    IAccountService accountService;

    @Test
    public void testTransfer() throws SQLException {
        accountService.transfer("one", "two", 100);
    }

    @Test
    public void testSaveAccount() throws SQLException {
        Account account = new Account();
        account.setId(5);
        account.setName("five");
        account.setMoney(1000f);
        accountService.saveAccount(account);
    }

    @Test
    public void testDeleteAccount() throws SQLException {
        accountService.deleteAccount(5);
    }

    @Test
    public void updateAccount()  throws SQLException{
        Account account = new Account();
        account.setId(1);
        account.setMoney(1000);
        accountService.updateAccount(account);
    }

    @Test
    public void searchAccounts() throws SQLException{
        List<Account> accountList =  accountService.searchAccounts(100f);
        for(Account account : accountList){
            System.out.println(account.toString());
        }
        System.out.println(accountList.size());
    }

    @Test
    public void searchAccountByName() throws SQLException{
        System.out.println(accountService.searchAccountByName("one").toString());
    }

    @Test
    public void serchCount() throws SQLException{
        System.out.println(accountService.serchCount(100f));
    }

}
