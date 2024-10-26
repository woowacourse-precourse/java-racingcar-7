package racingcar.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
}