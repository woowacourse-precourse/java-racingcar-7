package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.ConsoleInputView;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputViewTest {
    InputView inputView = new ConsoleInputView();

    Scanner scanner = new Scanner(System.in);

    @AfterEach
    void closeScanner() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"ash,green,hotpink", "ash, green",
            "ash ,green", "ash , green", "\n", "홍길동,두루미와다람쥐", "케서린 한"})
    @DisplayName("이름 입력 예외 테스트")
    void nameInputStringExceptionTest(String inputLine) {
        InputStream inputStream = new ByteArrayInputStream(inputLine.getBytes());
        System.setIn(inputStream);
        scanner = new Scanner(System.in);

        assertThatThrownBy(inputView::getCarNames).
                isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"마음껏달려봐", "111111111111111111111", "0", "\n"})
    @DisplayName("시도할 횟수 입력 예외 테스트")
    void chanceInputStringExceptionTest(String inputLine) {
        InputStream inputStream = new ByteArrayInputStream(inputLine.getBytes());
        System.setIn(inputStream);
        scanner = new Scanner(System.in);

        assertThatThrownBy(inputView::getChanceToMove).
                isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ash", "ash,green"})
    @DisplayName("이름 입력 테스트")
    void carNamesInputStringValidateTest(String inputLine) {
        InputStream inputStream = new ByteArrayInputStream(inputLine.getBytes());
        System.setIn(inputStream);
        scanner = new Scanner(System.in);

        assertDoesNotThrow(inputView::getCarNames);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "2025"})
    @DisplayName("시도할 횟수 입력 테스트")
    void chanceInputStringValidateTest(String inputLine) {
        InputStream inputStream = new ByteArrayInputStream(inputLine.getBytes());
        System.setIn(inputStream);
        scanner = new Scanner(System.in);

        assertDoesNotThrow(inputView::getCarNames);
    }

}
