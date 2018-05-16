package com.plgrnds.tests.bank;

/**
 * Created by sylwe on 16.05.2018.
 */
public enum DepositPeriod {
    ONEYEAR(12), TWOYEARS(24), THREEYEARS(36), FOURYEARS(48), FIVEYEARS(60);

    private Integer monthsAmount;
    DepositPeriod(Integer months) {
        monthsAmount = months;
    }

    public Integer getMonths() {
        return monthsAmount;
    }
}
