package racingcar;

import static racingcar.messages.ExceptionMessages.INVALID_CAR_NAME_FORMAT;
import static racingcar.messages.ExceptionMessages.NAME_TOO_LONG;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.io.InputHandler;
import racingcar.io.InputParser;
import racingcar.io.InputValidator;

public class InputTest {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();
    private final InputHandler inputHandler = new InputHandler();

    @Test
    void 입력값_파싱_테스트() {
        String inputString = "pobi,woni,jun";
//        Assertions.assertArrayEquals(new String[]{"pobi", "woni", "jun"}, inputParser.parseCarNames(inputString));
        Assertions.assertThat(inputParser.parseCarNames(inputString)).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 입력값_파싱_예외_테스트() {
        String[] inputStrings = {"pobi, woni, jun", "pobi,woni, jun", "pobi, woni,jun", " pobi,woni,jun",
                "pobi,woni,jun ", " pobi, woni, jun ", "pobi, woni, j un"};
        for (String inputString : inputStrings) {
            String[] carNames = inputString.split(",");
            Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_CAR_NAME_FORMAT.getMessage());
        }
    }

    @Test
    void 자동차_이름_길이_제한_테스트() {
        String[] carNames = {"pobii, woni, jun", "pobi, wonni, jun", "pobi, woni, jjunn"};
        Assertions.assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_TOO_LONG.getMessage());
    }

}
