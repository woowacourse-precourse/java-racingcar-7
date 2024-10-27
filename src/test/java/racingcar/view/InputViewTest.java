package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
    void closeConsole() {
        // 기존에 생성한 Scanner을 닫고, static 영역에 있는 Scanner을 null로 만든다.
        Console.close();
    }

    @DisplayName("경주할 자동차 이름을 입력하는 기능이 잘 수행되야 한다.")
    @Test
    void getCarNamesSuccess() {
        String expected = "pobi,woni,jun";
        String input = "pobi,woni,jun";

        SystemIn(input);
        String carNames = inputView.getCarNames();

        assertEquals(expected, carNames);
    }

    @Test
    @DisplayName("시도할 횟수를 입력하는 기능이 잘 수행되야 한다.")
    void getAttemptCount() {
        String expected = "5";
        String input = "5";

        SystemIn(input);
        String attemptCount = inputView.getAttemptCount();

        assertEquals(expected, attemptCount);
    }

    private static void SystemIn(final String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
