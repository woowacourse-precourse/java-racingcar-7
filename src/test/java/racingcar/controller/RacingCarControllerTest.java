package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import racingcar.config.RacingCarAppConfig;

class RacingCarControllerTest {
    @Test
    void 실제_콘솔_입력과_출력으로_경주_게임을_실행한다() {
        String input = "pobi,woni,jun\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RacingCarAppConfig config = new RacingCarAppConfig();
        RacingCarController racingCarController = config.raceGame();

        racingCarController.start();

        String output = outputStream.toString();
        assertThat(output).contains("실행 결과", "pobi : ", "woni : ", "jun : ", "최종 우승자 : ");
    }
}
