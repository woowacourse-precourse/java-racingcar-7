package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;
    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 자동차_입력_프롬프트_출력() {
        inputView.printCarNamePrompt();

        assertThat(outputStream.toString()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }
}
