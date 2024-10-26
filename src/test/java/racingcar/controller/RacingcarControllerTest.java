package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingcarControllerTest {

    RacingcarController controller;

    @BeforeEach
    void setUp() {
        controller = new RacingcarController();
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void 자동차_이름_입력_테스트() {
        // given
        setSystemInput("pobi,woni,jun");

        // when
        String result = controller.getCarNames();

        // then
        assertThat(result).isEqualTo("success");
    }

    @Test
    void 시도_횟수_입력_테스트() {
        // given
        setSystemInput("5");

        // when
        String result = controller.getAttemptCount();

        // then
        assertThat(result).isEqualTo("success");
    }

    private void setSystemInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
