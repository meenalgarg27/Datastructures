package com.meenal.datastructures;


import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        
        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }
    
    @Test
    public void accountCanHavePositiveOverdraftLimit() {
        Account account = new Account(20);
        
        Assert.assertEquals(20d, account.getOverdraftLimit(), epsilon);
    }
    
    @Test
    public void shouldNotDepositeMoneyisNeg() {
        Account account = new Account(10);
        boolean depositeFlag = account.deposit(-10);
        Assert.assertFalse(depositeFlag);
        Assert.assertEquals(0d, account.getBalance(),  epsilon);
    }
    
    @Test
    public void shouldDepositeMoneyisPositive() {
        Account account = new Account(10);
        boolean depositeFlag = account.deposit(10);
        Assert.assertTrue(depositeFlag);
        Assert.assertEquals(10d, account.getBalance(),  epsilon);
    }
    
    @Test
    public void cannotWithdrawMoneyWhenAmountisNeg() {
        Account account = new Account(10);
        account.deposit(20);
        boolean withdrawFlag = account.withdraw(-10);
        Assert.assertFalse(withdrawFlag);
    }
    
    @Test
    public void cannotWithdrawMoneyWhenBalanceisNotEnough() {
        Account account = new Account(10);
        account.deposit(20);
        boolean withdrawFlag = account.withdraw(40);
        Assert.assertFalse(withdrawFlag);
    }
    
    @Test
    public void canWithdrawMoneyWhenBalanceisEnough() {
        Account account = new Account(10);
        account.deposit(20);
        boolean withdrawFlag = account.withdraw(10);
        Assert.assertTrue(withdrawFlag);
        Assert.assertEquals(10d, account.getBalance(),  epsilon);
    }
}
