import com.plgrnds.tests.bank.Account;
import com.plgrnds.tests.bank.Customer;
import com.plgrnds.tests.bank.DepositAccount;
import com.plgrnds.tests.bank.DepositPeriod;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bartic on 23.05.2018.
 */

public class InterestRateTest {

    private Account account;
    private DepositAccount depositAccount;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp(){
        Customer customer = new Customer();
        account = new Account(customer);
        depositAccount = new DepositAccount(customer);

        depositAccount.setBalance(BigDecimal.valueOf(100.0));
        depositAccount.setPeriod(DepositPeriod.SIXMONTHS);
        depositAccount.setInterestRate(BigDecimal.valueOf(0.1));
    }

    @Test
    public void customerHasADepositAccount(){
        assertThat(depositAccount).isNotNull();
    }

    @Test
    public void areFundsOnDepositAccountCorrect(){
        assertEquals(depositAccount.getBalance().doubleValue(), 100.0, 0.0);
    }

    @Test
    public void customerHasAPrivateAccount(){
        assertThat(account).isNotNull();
    }

    @Test
    public void isInterestRateCorrect() {
        assertEquals(depositAccount.getInterestRate().doubleValue(), 0.1, 0.0);
    }

    @Test
    public void isPeriodCorrect() { assertEquals(depositAccount.getPeriod(), DepositPeriod.SIXMONTHS); }

    @Test
    public void isGainedAmountCorrect() {
        assertEquals(depositAccount.getBalanceIncreasedByInterest().doubleValue(), 105.0, 0.0);
    }

    @Test
    public void isAllMoneyTransferredBackProperly() {
        account.setBalance(account.getBalance().add(depositAccount.getBalanceIncreasedByInterest()));
        assertEquals(account.getBalance().doubleValue(), 105.0, 0.0);
    }
}
