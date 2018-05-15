import com.plgrnds.tests.bank.Customer;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

/**
 * Created by sylwe on 15.05.2018.
 */
public class CustomerTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Customer.class)
                .usingGetClass()
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }
}
