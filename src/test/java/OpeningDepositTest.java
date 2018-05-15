import com.plgrnds.tests.bank.Account;
import com.plgrnds.tests.bank.Customer;
import com.plgrnds.tests.bank.DepositAccount;
import com.plgrnds.tests.bank.NotEnoughMoneyException;
import org.junit.Before;
import org.junit.Test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by sylwe on 15.05.2018.
 */
public class OpeningDepositTest {

    private Account account;
    private DepositAccount depositAccount;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp(){
        Customer customer = new Customer();
        account = new Account(customer);
        depositAccount =  new DepositAccount(customer);

        account.setBalance(100.0);
    }

    @Test
    public void customerHasAnAccount(){

        assertThat(account).isNotNull();
    }

    @Test
    public void accountWithBalance(){
        assertEquals(account.getBalance(), 100.0, 0);
    }


    @Test
    public void customerOpenDepositAccount(){

        assertThat(depositAccount).isNotNull();
    }


    @Test
    public void openDepositAccountWithBalance() throws NotEnoughMoneyException{
        depositAccount.setBalance(account, 90);
        assertEquals(depositAccount.getBalance(), 90, 0);
    }


    @Test
    public void accountBalanceAfterOpenDepositAccount() throws NotEnoughMoneyException{
        depositAccount.setBalance(account, 90);
        assertEquals(account.getBalance(), 10, 0);
    }


    @Test
    public void whenCustomerWantOpenDepositAccountWithBalanceGreaterThatAccountBalanceThenException()
            throws NotEnoughMoneyException {

        exception.expect(NotEnoughMoneyException.class);
        depositAccount.setBalance(account, 110);
    }
}
