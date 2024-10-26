package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RacingcarControllerTest {

    private RacingcarController racingcarController;

    @BeforeEach
    void setUp() {
        Console.close();
        racingcarController = new RacingcarController();
    }

    @Test
    void 자동차_이름_입력_테스트() {
        // given
        setSystemInput("pobi,woni,jun");

        // when
        String result = racingcarController.getCarNames();

        // then
        assertThat(result).isEqualTo("success");
    }

    @Test
    void 시도_횟수_입력_테스트() {
        // given
        setSystemInput("5");

        // when
        String result = racingcarController.getAttemptCount();

        // then
        assertThat(result).isEqualTo("success");
    }

    @Test
    void 게임_진행_테스트() {
        // given
        setSystemInput("pobi,woni,jun");
        racingcarController.getCarNames();

        Console.close();
        setSystemInput("5");
        racingcarController.getAttemptCount();

        // when
        String result = racingcarController.proceedRacingGame();

        // then
        assertThat(result).isEqualTo("success");
    }

    @Test
    void 승자_확인_테스트() {
        // given
        setSystemInput("pobi,woni,jun");
        racingcarController.getCarNames();
        Console.close();

        setSystemInput("5");
        racingcarController.getAttemptCount();
        racingcarController.proceedRacingGame();

        // when
        String result = racingcarController.getWinners();

        // then
        assertThat(result).isEqualTo("success");
    }

    private void setSystemInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
