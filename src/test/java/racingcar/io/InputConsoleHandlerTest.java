package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputConsoleHandlerTest {


    @Test
    @DisplayName("콘솔에 자동차 이름을 입력하라는 안내 메시지를 출력한다")
    void showCarNameInputGuideMessageTest() {
        // given
        InputConsoleHandler inputConsoleHandler = new InputConsoleHandler();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        // when
        inputConsoleHandler.showCarNameGuideMessage();

        // then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + System.lineSeparator());

        System.setOut(System.out);

    }

    @Test
    @DisplayName("사용자는 자동차 이름들을 구분자로 나누어 입력한다")
    void carNameInput() {
        // given
        String input = "pobi,woni,jun";
        InputConsoleHandler inputConsoleHandler = new InputConsoleHandler();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        String[] carNames = inputConsoleHandler.askCarName();

        // then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("콘솔에 전진 시도 횟수를 입력하라는 안내 메시지를 출력한다")
    void showNumOfTryInputGuideMessageTest() {
        // given
        InputConsoleHandler inputConsoleHandler = new InputConsoleHandler();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        // when
        inputConsoleHandler.showNumOfTrialGuideMessage();

        // then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(
                "시도할 횟수는 몇 회인가요?" + System.lineSeparator());

        System.setOut(System.out);

    }

    @Test
    @DisplayName("사용자는 전진 시도 횟수를 입력한다")
    void numOfTrialInputTest() {
        // given
        String input = "5";
        InputConsoleHandler inputConsoleHandler = new InputConsoleHandler();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int numOfTrial = inputConsoleHandler.askNumOfTrial();

        // then
        assertThat(numOfTrial).isEqualTo(5);
        System.setIn(System.in);
        Console.close();
    }

    @ParameterizedTest
    @MethodSource("invalidNumOfTrialCases")
    @DisplayName("적절하지 않은 형식의 문자를 시도 횟수로써 입력할 수 있다")
    void invalidNumOfTrialThrowsExceptions(String input, String expectedErrorMessage) {

        // given
        InputConsoleHandler inputConsoleHandler = new InputConsoleHandler();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when, then
        assertThatThrownBy(inputConsoleHandler::askNumOfTrial)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);

        System.setIn(System.in);
        Console.close();
    }

    private static Stream<Arguments> invalidNumOfTrialCases() {
        return Stream.of(
                Arguments.arguments("1.5", "시도할 횟수는 정수여야 합니다. 입력 : 1.5"),
                Arguments.arguments("ab", "시도할 횟수에 숫자가 아닌 값이 입력되었습니다. 입력 : ab"),
                Arguments.arguments("-3", "시도할 횟수는 0보다 커야 합니다."),
                Arguments.arguments("2147483649", "허용 가능한 시도 횟수를 초과하였습니다.")
        );
    }
}