package racingcar;

import static racingcar.messages.ExceptionMessages.EMPTY_NAME;
import static racingcar.messages.ExceptionMessages.INVALID_CAR_NAME_FORMAT;
import static racingcar.messages.ExceptionMessages.INVALID_INTEGER_RANGE;
import static racingcar.messages.ExceptionMessages.INVALID_ROUNDS_INPUT;
import static racingcar.messages.ExceptionMessages.NAME_TOO_LONG;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.io.InputHandler;
import racingcar.io.InputParser;
import racingcar.io.InputValidator;

public class InputTest {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();
    private final InputHandler inputHandler = new InputHandler();

    @AfterAll
    static void close() {
        Console.close();
    }

    @Test
    void 입력_테스트() {
        System.setIn(new ByteArrayInputStream("pobi,woni,jun".getBytes()));
        String[] carNames = inputHandler.inputCarNamesProcess();
        Assertions.assertThat(carNames)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 입력값_파싱_테스트() {
        String inputString = "pobi,woni,jun";
        Assertions.assertThat(inputParser.parseCarNames(inputString))
                .containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "pobi, woni, jun", "pobi,woni, jun", "pobi, woni,jun", " pobi,woni,jun",
            "pobi,woni,jun ", " pobi, woni, jun ", "pobi, woni, j un"
    })
    void 입력값_공백_포함_예외_테스트(String inputString) {
        String[] carNames = inputParser.parseCarNames(inputString);
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiii,woni,jun", "pobi,wonnii,jun", "pobi,woni,jjjunn"})
    void 자동차_이름_5자_이하만_가능_예외_테스트(String inputString) {
        String[] carNames = inputParser.parseCarNames(inputString);
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_TOO_LONG.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ",woni,jun", "jun,", ",jun,"})
    void 빈문자열_이름_예외_테스트(String inputString) {
        String[] carNames = inputParser.parseCarNames(inputString);
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-100"})
    void 이동횟수_양의정수만_가능_예외_테스트(String inputString) {
        Assertions.assertThatThrownBy(() -> inputValidator.validateNumberOfRound(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ROUNDS_INPUT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "-2147483649"})
    void 이동횟수_정수범위만_가능_예외_테스트(String inputString) {
        Assertions.assertThatThrownBy(() -> inputValidator.validateNumberOfRound(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INTEGER_RANGE.getMessage());
    }
}
