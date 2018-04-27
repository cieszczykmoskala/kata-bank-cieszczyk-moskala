package com.plgrnds.tests.bank

import spock.lang.Specification

import static org.junit.Assert.assertEquals


class TransferMoneyTest extends Specification {

    def "money is transfered from account A to B"() {
        when:
        accountA.setBalance(100.0)
        accountB.setBalance(1000.0)
        paymentService.transferMoney(accountA, accountB,99.91)

        then:
        assertEquals(accountA.getBalance(), 0.09, 0.0001)
        assertEquals(accountB.getBalance(), 1099.91, 0.0001)

        where:
        customerOne = new Customer()
        accountA = new Account(customerOne)
        customerTwo = new Customer()
        accountB = new Account(customerTwo)
        paymentService = new PaymentService()
    }
}
