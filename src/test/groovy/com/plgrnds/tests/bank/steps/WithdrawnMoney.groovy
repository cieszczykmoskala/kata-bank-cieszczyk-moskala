package com.plgrnds.tests.bank.steps

import com.plgrnds.tests.bank.Account
import com.plgrnds.tests.bank.Customer
import com.plgrnds.tests.bank.PaymentService
import groovy.transform.Field

import static org.assertj.core.api.Assertions.assertThat

this.metaClass.mixin(cucumber.api.groovy.EN)

/**
 * Created by sylwe on 27.04.2018.
 */

@Field customer
@Field Account account
@Field paymentService


Given(~/^balance on the account is 100$/) { ->
    customer = new Customer()
    account = new Account(customer)
    account.setBalance(100.0)
}


When(~/^customer withdrawns 90 to this account$/) { ->
    paymentService = new PaymentService()
    paymentService.withdrawnMoney(account, 90)
}

Then(~/^balance on the account is 10$/) { ->
    assertThat(account.getBalance()).isEqualTo(10)
}
