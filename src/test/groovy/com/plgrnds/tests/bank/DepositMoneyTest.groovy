package com.plgrnds.tests.bank

import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

/**
 * Created by sylwe on 27.04.2018.
 */
class DepositMoneyTest extends Specification {

    def "customer deposits 10 to this account and balance on the account is 110"() {
        when:
        account.setBalance(100.0)
        paymentService.depositMoney(account, 10)

        then:
        assertThat(account.getBalance().doubleValue()).isEqualTo(110)

        where:
        customer = new Customer()
        account = new Account(customer)
        paymentService = new PaymentService()
    }
}
