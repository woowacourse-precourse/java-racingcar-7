package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class OutputViewTest {
    private ByteArrayOutputStream byteArrayOutputStream;
    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    void restoreSystemOut() {
        System.setOut(System.out);
    }

    @Test
    void requestCarNameTest() {
        OutputView.requestCarName();
        assertThat("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)").isEqualTo(byteArrayOutputStream.toString().trim());
    }

    @Test
    void requestTryNumberTest() {
        OutputView.requestTryNumber();
        assertThat("시도할 횟수는 몇 회인가요?").isEqualTo(byteArrayOutputStream.toString().trim());
    }

    @Test
    void printExecutionMessageTest() {
        OutputView.printExecutionMessage();
        assertThat("실행 결과").isEqualTo(byteArrayOutputStream.toString().trim());
    }

    @Test
    void printCarStateTest() {
        OutputView.printCarState("jeong", "--");
        assertThat("jeong : --").isEqualTo(byteArrayOutputStream.toString().trim());
    }

    @Test
    void printNewLineTest() {
        OutputView.printNewLine();
        assertThat("").isEqualTo(byteArrayOutputStream.toString().trim());
    }

    @Test
    void printWinnerTest() {
        OutputView.printWinner("hun");
        assertThat("최종 우승자 : hun").isEqualTo(byteArrayOutputStream.toString().trim());
    }
}