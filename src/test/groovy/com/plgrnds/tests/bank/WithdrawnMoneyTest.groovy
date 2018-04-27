package com.plgrnds.tests.bank

import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat


/**
 * Created by sylwe on 27.04.2018.
 */
class WithdrawnMoneyTest extends Specification {

    def "customer withdrawns 90 to this account and balance on the account is 10"() {
        when:
        account.setBalance(100.0)
        paymentService.withdrawnMoney(account, 90)

        then:
        assertThat(account.getBalance()).isEqualTo(10)

        where:
        customer = new Customer()
        account = new Account(customer)
        paymentService = new PaymentService()
    }
}
