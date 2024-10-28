package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.validator.ErrorMessage.TOTAL_ATTEMPTS_OVERFLOW_ERROR;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputProcessorTest {
    private UserInputProcessor userInputProcessor;

    @BeforeEach
    void setUp() {
        userInputProcessor = new UserInputProcessor();
    }

    @Test
    void 자동차_이름을_정상적으로_구분할_수_있다() {
        //given
        String userInput = "pobi,woni,jun";
        //when
        List<String> carNames = userInputProcessor.processCarName(userInput);
        //then
        assertThat(carNames)
                .containsOnly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {",pobi,woni,jun", "pobi,,woni,jun", "pobi,woni,jun,"})
    void 구분자가_2개의_문자열을_구분하지_않아도_정상적으로_구분할_수_있다(String userInput) {
        List<String> carNames = userInputProcessor.processCarName(userInput);
        assertThat(carNames)
                .containsOnly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ,tv,cable", "tv, ,cable", "tv,cable, "})
    void 구분자가_공백_문자열을_분리해도_이를_제거할_수_있다(String userInput) {
        List<String> carNames = userInputProcessor.processCarName(userInput);
        assertThat(carNames)
                .hasSize(2)
                .containsOnly("tv", "cable");
    }

    @Test
    void 자동차_이름의_공백을_정상적으로_제거할_수_있다() {
        //given
        String userInput = " bee, bug ,insect  ";
        //when
        List<String> carNames = userInputProcessor.processCarName(userInput);
        //then
        assertThat(carNames).isEqualTo(List.of("bee", "bug", "insect"));
    }

    @Test
    void 총_시도횟수를_정상적으로_변환한다() {
        //given
        String userInput = "34 ";
        //when
        Integer totalAttempts = userInputProcessor.processTotalAttempts(userInput);
        //then
        assertThat(totalAttempts).isEqualTo(34);
    }

    @Test
    void 총_시도횟수가_정수_범위를_넘는다() {
        String userInput = "2147483648";
        Assertions.assertThatThrownBy(() -> userInputProcessor.processTotalAttempts(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOTAL_ATTEMPTS_OVERFLOW_ERROR.getMessage());
    }
}