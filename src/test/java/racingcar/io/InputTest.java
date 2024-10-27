package racingcar.io;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class InputTest extends NsTest {

    @Test
    void emptyInputTest() {
        assertAll(
            () -> assertThatThrownBy(() -> run(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다."),
            () -> assertThatThrownBy(() -> run("\n"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다.")
        );
    }

    @Test
    void blankInputTest() {
        String answer = " ";
        System.setIn(new ByteArrayInputStream(answer.getBytes()));

        assertThatThrownBy(() -> run(" "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 입력입니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
