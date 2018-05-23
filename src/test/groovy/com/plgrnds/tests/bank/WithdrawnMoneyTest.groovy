package com.plgrnds.tests.bank

import org.assertj.core.data.Offset
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat


/**
 * Created by sylwe on 27.04.2018.
 */
class WithdrawnMoneyTest extends Specification {

    def "customer withdraws 90 from this account and balance on the account is 10"() {
        when:
        account.setBalance(100.0)
        paymentService.withdrawnMoney(account, 90)

        then:
        assertThat(account.getBalance().doubleValue()).isEqualTo(10)

        where:
        customer = new Customer()
        account = new Account(customer)
        paymentService = new PaymentService()
    }
}
