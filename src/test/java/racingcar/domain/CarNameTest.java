package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("1-5자 사이의 영어 혹은 한글로 이뤄진 이름을 만들 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcde", "a", "ㄴr"})
    void canCreateCarName(String name) {
        //given
        //when
        CarName carName = new CarName(name);
        //then
        assertThat(carName.name()).isEqualTo(name);
    }

    @DisplayName("자동차 이름에 영어, 한글 외의 문자가 포함되어 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a1", "a a", "*a*", "[a]"})
    void throwsExceptionWhenFormatIsWrong(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름에 특수문자를 포함할 수 없으며, 콤마로 이름을 구분해 주세요.");
    }

    @DisplayName("자동차 이름이 공백이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void throwsExceptionWhenIsBlank(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 공백없이 최소 1자부터 가능합니다.");
    }

    @DisplayName("자동차 이름이 5자 초과면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "가나다라마바", "a가b나c다"})
    void throwsExceptionWhenLengthIsOutOfRange(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최대 5자까지 가능합니다.");
    }
}