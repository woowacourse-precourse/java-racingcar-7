package racingcar.test.serviceTest.decisionTest;

import org.junit.jupiter.api.Test;
import racingcar.service.decision.ForwardOrNot;
import racingcar.service.decision.ForwardOrNotEmb;

import static org.assertj.core.api.Assertions.assertThat;

public class ForwardOrNotTestEmb implements ForwardOrNotTest {
    @Test
    public void testIsBiggerOrEqualFour() {
        ForwardOrNot forwardOrNot = new ForwardOrNotEmb();
        assertThat(forwardOrNot.isBiggerOrEqualFour()).isInstanceOf(Boolean.class);
    }
}
