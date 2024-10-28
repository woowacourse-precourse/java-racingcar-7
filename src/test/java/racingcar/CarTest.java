package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "testCar"})
    @DisplayName("이름의_길이_조건을_만족하지_않으면_예외를_발생한다")
    public void should_ThrowException_When_NameLengthIsInvalid(String input) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최소 1글자, 최대 5글자입니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n", "\\", "ab-c"})
    @DisplayName("이름에_영문자와_숫자_이외의_문자를_입력하면_예외를_발생한다")
    public void should_ThrowException_When_NameNotOnlyEnglishAndNumber(String input) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 영문자와 숫자만 허용합니다");
    }
}