package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    @DisplayName("입력을 받는 데 성공한다.")
    void getCarNames_Success() {
        String carNames = "pobi,DK,jun";
        getSystemInput(carNames);
        Assertions.assertThat(inputView.getCarsNames()).isEqualTo(carNames);
    }

    @Test
    @DisplayName("NoSuchElementException 발생 시 IllegalArgumentException으로 변환된다.")
    void noSuchElementExceptionIsConverted() {
        String emptyLine = "";
        getSystemInput(emptyLine);

        assertThatThrownBy(() -> inputView.getCarsNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NO_LINES_FOUND.getMessage());
    }

    @Test
    @DisplayName("RuntimeException 발생 시 그대로 터진다.")
    void unexpectedExceptionIsHandled() {
        String exceptionMessage = "강제 발생한 RuntimeException";
        InputStream mockIn = new InputStream() {
            @Override
            public int read() {
                throw new RuntimeException(exceptionMessage);
            }
        };
        System.setIn(mockIn);

        assertThatThrownBy(() -> inputView.getCarsNames())
                .isInstanceOf(RuntimeException.class)
                .hasMessage(exceptionMessage);
    }

    private static void getSystemInput(String emptyLine) {
        InputStream mockIn = new ByteArrayInputStream(emptyLine.getBytes());
        System.setIn(mockIn);
    }
}
