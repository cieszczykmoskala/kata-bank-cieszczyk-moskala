package com.plgrnds.tests.bank;


import java.math.BigDecimal;

public class PaymentService {


    public void transferMoney(Account accountOne, Account accountTwo, BigDecimal moneyToTransfer){
        accountOne.setBalance(accountOne.getBalance().subtract(moneyToTransfer));
        accountTwo.setBalance(accountTwo.getBalance().add(moneyToTransfer));
    }

    public void depositMoney(Account account, BigDecimal moneyDeposit){
        account.setBalance(account.getBalance().add(moneyDeposit));
    }

    public void withdrawnMoney(Account account, BigDecimal moneyDeposit){
        account.setBalance(account.getBalance().subtract(moneyDeposit));
    }
}
