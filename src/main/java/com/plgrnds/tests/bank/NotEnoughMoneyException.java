package com.plgrnds.tests.bank;

/**
 * Created by sylwe on 15.05.2018.
 */
public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
