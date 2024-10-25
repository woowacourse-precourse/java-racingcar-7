package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Utils.enterCarList;
import static racingcar.Utils.enterRound;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    void dummyInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void enterCarList_test() {
        dummyInput("pobi, woni");

        assertThat(enterCarList())
                .contains("pobi")
                .contains("woni");
    }

    @Test
    void enterRound_test() {
        dummyInput("3");
        assertThat(enterRound()).isEqualTo(3);
    }

    @Test
    void enterRound_negative_exception_test() {
        dummyInput("-1");
        assertThatThrownBy(() -> enterRound())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void enterRound_invalid_exception_test() {
        dummyInput("aa");
        assertThatThrownBy(() -> enterRound())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
