package com.plgrnds.tests.bank;


public class PaymentService {


    public void transferMoney(Account accountOne, Account accountTwo, double moneyToTransfer){
        accountOne.setBalance(accountOne.getBalance() - moneyToTransfer);
        accountTwo.setBalance(accountTwo.getBalance() + moneyToTransfer);
    }

    public void depositMoney(Account account, double moneyDeposit){
        account.setBalance(account.getBalance() + moneyDeposit);
    }

    public void withdrawnMoney(Account account, double moneyDeposit){
        account.setBalance(account.getBalance() - moneyDeposit);
    }
}
