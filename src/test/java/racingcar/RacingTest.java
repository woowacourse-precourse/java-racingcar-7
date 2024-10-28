package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {

    static Racing racing;

    @BeforeAll
    static void setUpRacing() {
        WoowaGoMethod woowaGoMethod = new WoowaGoMethod();
        racing = new Racing(woowaGoMethod);
    }

    @Test
    @DisplayName("들어온 이름 중 limit number 가 넘어가는 경우 illegalException 발생해야 한다.")
    void invalidCarNamesOverLimitLengthTest() {
        String carNames = "pobi,javaji";
        int round = 5;

        assertThatThrownBy(() -> racing.doRacing(carNames, round)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("들어온 이름 중 공백이 있는 경우 illegalException 발생해야 한다.")
    void invalidCarNamesEmptyNameTest() {
        String carNames = "pobi, ,";
        int round = 5;

        assertThatThrownBy(() -> racing.doRacing(carNames, round)).isInstanceOf(IllegalArgumentException.class);
    }


}