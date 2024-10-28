package racingcar.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
}