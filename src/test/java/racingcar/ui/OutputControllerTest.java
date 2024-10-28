package racingcar.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Winners;

class OutputControllerTest {

    @Test
    void 자동차이름_입력형식_출력() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);

        final OutputController outputController = new OutputController(new OutputConsole());
        outputController.printNameInputInformation();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼포(,) 기준으로 구분)" + "\n");
    }

    @Test
    void 라운드_입력형식_출력() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);

        final OutputController outputController = new OutputController(new OutputConsole());
        outputController.printRoundInputInformation();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("시도할 횟수는 몇 회인가요?" + "\n");
    }

    @Test
    void 라운드_진행도_출력() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);

        final OutputController outputController = new OutputController(new OutputConsole());

        outputController.printProgressedInfo(
                List.of(
                        new ProgressedInformation("test", 5),
                        new ProgressedInformation("test", 5)
                )
        );

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("test : -----\n" + "test : -----\n" + "\n");
    }

    @ParameterizedTest
    @MethodSource("provideWinners")
    void 우승자_출력() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);

        final OutputController outputController = new OutputController(new OutputConsole());
        outputController.printWinners(new WinnerResults(List.of("test", "pobi", "json")));
        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo("최종 우승자 : test, pobi, json");
    }

    static Stream<Arguments> provideWinners() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new WinnerResult("test"),
                                new WinnerResult("pobi"),
                                new WinnerResult("json")
                        ), "최종 우승자 : test, pobi, json"
                ),
                Arguments.of(
                        List.of(
                                new WinnerResult("test")
                        ), "최종 우승자 : test")
        );
    }
}