package com.plgrnds.tests.bank;


public class PaymentService {


    public void transferMoney(Account accountOne, Account accountTwo, double moneyToTransfer){
        accountOne.setBalance(accountOne.getBalance() - moneyToTransfer);
        accountTwo.setBalance(accountTwo.getBalance() + moneyToTransfer);
    }
}
