package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void beforeEach() {
        inputView = new InputView();
    }

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    void 정상_문자열_입력을_처리한다() {
        // given
        String input = "pobi";
        provideSetInputStream(input);

        // when
        String inputCarsName = inputView.inputCarNames();

        // then
        Assertions.assertEquals(input, inputCarsName);
    }

    @Test
    void 정상_횟수_입력을_처리한다() {
        // given
        String input = "5";
        provideSetInputStream(input);

        // when
        int inputPlayCount = inputView.inputTryCount();

        // then
        Assertions.assertEquals(input, String.valueOf(inputPlayCount));
    }

    @ParameterizedTest(name = "입력값: \"{0}\"")
    @ValueSource(strings = {"      ", ",", "\n"})
    void 비정상_자동차_이름_입력을_예외_처리한다(String input) {
        // given
        provideSetInputStream(input);

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
                inputView::inputCarNames
        );
    }

    @ParameterizedTest(name = "입력값: \"{0}\"")
    @ValueSource(strings = {"0", "1000001"})
    void 비정상_플레이_횟수_입력을_예외_처리한다(String input) {
        // given
        provideSetInputStream(input);

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class,
                inputView::inputTryCount
        );
    }

    private void provideSetInputStream(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}