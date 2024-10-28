package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Utils.enterCarList;
import static racingcar.Utils.enterRound;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    private final InputStream originalSystemIn = System.in;

    void dummyInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @AfterEach
    void tearDown() {
        Console.close();
        System.setIn(originalSystemIn);
    }

    @DisplayName("[정상 테스트]Utils.enterCarList - 각 이름이 1자 이상 5자 이하")
    @Test
    void enterCarList_test() {
        dummyInput("pobi, woni");

        assertThat(enterCarList())
                .contains("pobi")
                .contains("woni");
    }

    @DisplayName("[정상 테스트]Utils.enterCarList - 이름의 앞뒤 공백 제거")
    @Test
    void enterCarList_strip_test() {
        dummyInput("  po bi , w oni  ");

        assertThat(enterCarList())
                .contains("po bi")
                .contains("w oni");
    }

    @DisplayName("[정상 테스트]Utils.enterRound - 입력이 양의 정수형")
    @Test
    void enterRound_test() {
        dummyInput("3");
        assertThat(enterRound()).isEqualTo(3);
    }

    @DisplayName("[예외 테스트]:Utils.enterRound- 입력의 음의 정수형")
    @Test
    void enterRound_negative_exception_test() {
        dummyInput("-1");
        assertThatThrownBy(() -> enterRound())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[예외 테스트]:Utils.enterRound- 입력이 정수가 아닌 문자형")
    @Test
    void enterRound_invalid_exception_test() {
        dummyInput("aa");
        assertThatThrownBy(() -> enterRound())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
