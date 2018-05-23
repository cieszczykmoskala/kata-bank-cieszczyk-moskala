import com.plgrnds.tests.bank.Account;
import com.plgrnds.tests.bank.Customer;
import com.plgrnds.tests.bank.DepositAccount;
import com.plgrnds.tests.bank.DepositPeriod;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;


/**
 * Created by sylwe on 15.05.2018.
 */
public class TerminationDateTest {

    private DepositAccount depositAccount;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp(){
        Customer customer = new Customer();
        depositAccount =  new DepositAccount(customer);
        depositAccount.setPeriod(DepositPeriod.ONEYEAR);
    }

    @Test
    public void customerOpenDepositAccount(){
        Assertions.assertThat(depositAccount).isNotNull();
    }


    @Test
    public void openDepositAccountForAPeriod(){
        assertThat(depositAccount.getPeriod()).isEqualTo(DepositPeriod.ONEYEAR);
    }

    @Test
    public void openDepositAccountForAPeriodPartTwo(){
        assertThat(depositAccount.getPeriod().getMonths()).isEqualTo(12);
    }

    @Test
    public void whenMoneyBackToTheAccount(){
        String result = "Money can be returned to your account";
        assertEquals(depositAccount.moneyBackToAccount(12), result);
        assertEquals(depositAccount.moneyBackToAccount(13), result);
    }

    @Test
    public void whenMonthsAmountIsLessThanDepositPeriod(){
        exception.expect(RuntimeException.class);
        depositAccount.moneyBackToAccount(11);
        depositAccount.moneyBackToAccount(5);
        depositAccount.moneyBackToAccount(1);
    }
}
