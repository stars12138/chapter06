package com.itheima.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void mainTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.execute("create table account("+"id int primary key auto_increment,"+"username varchar(50),"+"balance double)");
        System.out.println("创建成功");
    }
    @Test
    public void addAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao= (AccountDao) applicationContext.getBean("accountDao");
        Account account=new Account();
        account.setUsername("tom");
        account.setBalance(1000.100);
        int num=accountDao.addAccount(account);
        if (num>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }
    @Test
    public void updateAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao= (AccountDao) applicationContext.getBean("accountDao");
        Account account=new Account();
        account.setId(1);
        account.setUsername("tom");
        account.setBalance(2000.00);
        int num=accountDao.updateAccount(account);
        if (num>0){
            System.out.println("修改成功1");
        }else {
            System.out.println("修改失败2");
        }
    }
    @Test
    public void deleteAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao= (AccountDao) applicationContext.getBean("accountDao");
        int num= accountDao.deleteAccount(1);
        if (num>0){
            System.out.println("删除成功1");
        }else {
            System.out.println("删除失败2");
        }
    }
    @Test
    public void findAccountByIdTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao= (AccountDao) applicationContext.getBean("accountDao");
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void findAllAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao= (AccountDao) applicationContext.getBean("accountDao");
        List<Account> accounts=accountDao.findAllAccount();
        for (Account act: accounts){
            System.out.println(act);
        }
    }
}