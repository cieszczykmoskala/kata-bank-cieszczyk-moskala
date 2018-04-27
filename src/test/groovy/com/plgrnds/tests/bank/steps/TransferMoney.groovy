package com.plgrnds.tests.bank.steps

import com.plgrnds.tests.bank.Account
import com.plgrnds.tests.bank.Bank
import com.plgrnds.tests.bank.Customer
import com.plgrnds.tests.bank.InMemoryAccountRepository
import com.plgrnds.tests.bank.PaymentService
import groovy.transform.Field

import static org.assertj.core.api.Assertions.*

this.metaClass.mixin(cucumber.api.groovy.EN)


@Field accountRepository
@Field bankA

@Field customerOne
@Field customerTwo

@Field Account accountA
@Field Account accountB

@Field paymentService


Given(~/^balance on account A is 100$/) { ->
    customerOne = new Customer()
    accountA = new Account(customerOne)
    accountA.setBalance(100.0)
}

And(~/^balance on account B is 1000$/) { ->
    customerTwo = new Customer()
    accountB = new Account(customerTwo)
    accountB.setBalance(1000.0)
}


When(~/^99.91 is transfered from account A to B$/) { ->
    paymentService = new PaymentService()
    paymentService.transferMoney(accountA, accountB,99.91)
}

Then(~/^balance on account A is 0.09$/) { ->
    assertThat(accountA.getBalance()).isEqualTo(0.09)
}

And(~/^balance on account B is 1099.91$/) { ->
    assertThat(accountB.getBalance()).isEqualTo(1099.91)
}