package com.itheima.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
}