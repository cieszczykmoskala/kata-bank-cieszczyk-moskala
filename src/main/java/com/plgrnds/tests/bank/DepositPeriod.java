package com.plgrnds.tests.bank;

/**
 * Created by sylwe on 16.05.2018.
 */
public enum DepositPeriod {
    ONEYEAR("12months"), TWOYEARS("24months"), THREEYEARS("36months"), FOURYEARS("48months"), FIVEYEARS("60months");

    private String description;
    DepositPeriod(String desc) {
        description = desc;
    }

    public String getDescription() {
        return description;
    }
}
