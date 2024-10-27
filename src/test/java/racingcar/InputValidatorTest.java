package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 시 빈 문자열 검증")
    @EmptySource
    void 자동차_빈_문자열_테스트(String input) {
        assertThatThrownBy(() -> InputValidator.validateCarNames(input, List.of(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열이 입력되었습니다.");
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 시 잘못된 구분자 검증")
    @ValueSource(strings = {"car1.car2.car3", "pobi;kim;lee"})
    void 자동차_쉼표_구분_테스트(String input) {
        List<String> carNames = List.of(input);
        assertThatThrownBy(() -> InputValidator.validateCarNames(input, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 쉼표(,)로 구분해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("자동차 중복 이름 검증")
    @CsvSource({"car1,car1,car2", "pobi,woo,woo", "a,b,b"})
    void 자동차_중복_이름_검증_테스트(String car1, String car2, String car3) {
        List<String> carNames = List.of(car1, car2, car3);
        assertThatThrownBy(() -> InputValidator.validateCarNames(String.join(",", carNames), carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름의 차가 존재합니다.");
    }

    @ParameterizedTest
    @DisplayName("자동차 길이 검증")
    @CsvSource({"pororo, lee, lim", "woowacourse, tech, pre"})
    void 자동차_길이_검증_테스트(String car1, String car2, String car3) {
        List<String> carNames = List.of(car1, car2, car3);
        assertThatThrownBy(() -> InputValidator.validateCarNames(String.join(",", carNames), carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }
}
