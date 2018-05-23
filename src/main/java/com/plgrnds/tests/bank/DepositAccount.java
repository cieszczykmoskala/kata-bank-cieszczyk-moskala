package com.plgrnds.tests.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by sylwe on 15.05.2018.
 */
public class DepositAccount {
    private Customer customer;
    private BigDecimal balance;
    private DepositPeriod depositPeriod;
    private BigDecimal interestRate = BigDecimal.valueOf(0.0);

    public DepositAccount(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getBalanceIncreasedByInterest(){
        balance = balance.add((balance.multiply(interestRate).multiply(BigDecimal.valueOf(depositPeriod.getMonths()))).divide(BigDecimal.valueOf(12)));
        return balance;
    }

    public void setBalance(Account account, BigDecimal moneyTransferOnDesposit) throws NotEnoughMoneyException  {
        if(moneyTransferOnDesposit.compareTo(account.getBalance()) > 0)
            throw new NotEnoughMoneyException("Not enough money an your account");

        this.balance = moneyTransferOnDesposit;
        account.setBalance(account.getBalance().subtract(moneyTransferOnDesposit));
    }

    public void setBalance(BigDecimal initialBalance){
        this.balance = initialBalance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public DepositPeriod getPeriod(){
        return depositPeriod;
    }

    public void setPeriod(DepositPeriod depositPeriod){
        this.depositPeriod = depositPeriod;
    }

    public String moneyBackToAccount(Integer monthsAmountFromStartDepositAccount){
        if(monthsAmountFromStartDepositAccount < depositPeriod.getMonths())
            throw new RuntimeException("Deposit period is not over yet. " +
                    "Money can not be returned to your account");

        return "Money can be returned to your account";

    }
}
