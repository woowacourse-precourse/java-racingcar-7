package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidateCarTest {

    @DisplayName("자동차 이름이 5자를 넘으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "가나다라마바사아자", "pobi,javaji"})
    void 이름길이_초과_예외_테스트(String name) {
        assertThatThrownBy(() -> ValidateCar.validateInputCar(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표를 기준으로 앞,뒤에 이름이 오지않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,,java", ",,", "pobi,", ",pobi"})
    void 쉼표_형식_예외_테스트(String name) {
        assertThatThrownBy(() -> ValidateCar.validateInputCar(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 문자열이나 스페이스가 들어오면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 입력이_빈문자열인_경우_예외_테스트(String name) {
        assertThatThrownBy(() -> ValidateCar.validateInputCar(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}