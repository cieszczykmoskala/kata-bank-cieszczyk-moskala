
import com.plgrnds.tests.bank.Account;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

/**
 * Created by sylwe on 15.05.2018.
 */
public class AccountTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Account.class)
                .usingGetClass()
                .suppress(Warning.ALL_FIELDS_SHOULD_BE_USED)
                .verify();
    }
}
