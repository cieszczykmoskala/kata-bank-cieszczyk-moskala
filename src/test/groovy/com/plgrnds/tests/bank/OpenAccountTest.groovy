package com.plgrnds.tests.bank

import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat



class OpenAccountTest extends Specification {

    private final InMemoryAccountRepository repository = new InMemoryAccountRepository()

    def "new account can be opened by customer and its balance equals 0"() {
        when:
        repository.addAccount(newAccount)

        then:
        assertThat(newAccount.getBalance().doubleValue()).isEqualTo(0)

        where:
        customer = new Customer()
        newAccount = new Account(customer)
    }
}
