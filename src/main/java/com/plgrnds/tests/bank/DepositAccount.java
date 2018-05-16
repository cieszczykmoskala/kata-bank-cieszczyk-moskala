package com.plgrnds.tests.bank;

import java.time.LocalDate;

/**
 * Created by sylwe on 15.05.2018.
 */
public class DepositAccount {
    private Customer customer;
    private double balance;
    private DepositPeriod depositPeriod;

    public DepositAccount(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Account account, double moneyTransferOnDesposit) throws NotEnoughMoneyException  {
        if(moneyTransferOnDesposit > account.getBalance())
            throw new NotEnoughMoneyException("Not enough money an your account");

        this.balance = moneyTransferOnDesposit;
        account.setBalance(account.getBalance() - moneyTransferOnDesposit);
    }

    public DepositPeriod getPeriod(){
        return depositPeriod;
    }

    public void setPerdiod(DepositPeriod depositPeriod){
        this.depositPeriod = depositPeriod;
    }

    public String moneyBackToAccount(Integer monthsAmountFromStartDepositAccount){
        if(monthsAmountFromStartDepositAccount < depositPeriod.getMonths())
            throw new RuntimeException("Deposit period is not over yet. " +
                    "Money can not be returned to your account");

        return "Money can be returned to your account";

    }
}
