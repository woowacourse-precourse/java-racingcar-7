package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Utils.enterCarList;

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
}
