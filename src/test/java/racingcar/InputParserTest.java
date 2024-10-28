package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        this.inputParser = new InputParser();
    }

    @Test
    @DisplayName("유효한 자동차 이름 입력")
    void giveValidCarNames() {
        //given
        String input = "pobi, woni, jun";
        //when
        List<String> cars = inputParser.splitToCars(input);
        //then
        Assertions.assertThat(cars)
                .hasSize(3)
                .contains("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("이름의 길이가 5를 초과하면 IllegalArgumentsException")
    void putLongCarName() {
        //given
        String input = "pobi, woniwo, jun";

        //when, then
        Assertions.assertThatThrownBy(() -> inputParser.splitToCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름의 길이가 0이면 IllegalArgumentsException")
    void putEmptyName() {
        //given
        String input = "pobi, , jun";

        //when, then
        Assertions.assertThatThrownBy(() -> inputParser.splitToCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효한 시도 횟수 입력")
    void putNumber() {
        //given
        String input = "1";
        //when
        long attemptNumber = inputParser.parseAttemptNumber(input);
        // then
        Assertions.assertThat(attemptNumber).isEqualTo(1);
    }

    @Test
    @DisplayName("시도 횟수로 0 입력 시 IllegalArgumentException")
    void putNumberSmallerThenOne() {
        //given
        String input = "0";

        //when, then
        Assertions.assertThatThrownBy(() -> inputParser.parseAttemptNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1보다 작은 시도 횟수 입력 시 IllegalArgumentException")
    void putMinusNumber() {
        //given
        String input = "-1";

        //when, then
        Assertions.assertThatThrownBy(() -> inputParser.parseAttemptNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}