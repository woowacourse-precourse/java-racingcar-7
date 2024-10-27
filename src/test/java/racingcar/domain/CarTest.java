package racingcar.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameContainsWhiteSpaceException;
import racingcar.exception.CarNameLengthException;
import racingcar.exception.NonBlankCarNameException;

class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이동 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move(int moveCondition) {
        //given
        Car car = new Car("james");

        //when
        car.move(moveCondition);
        int position = car.getPosition();

        //then
        Assertions.assertThat(position).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차 정지 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    void carDoesNotMove(int moveCondition) {
        //given
        Car car = new Car("james");

        //when
        car.move(moveCondition);
        int position = car.getPosition();

        //then
        Assertions.assertThat(position).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자 이하가 아닐 경우, 예외를 발생시킨다.")
    @ValueSource(strings = {"abcdef", "abcdefg", "abcdefghijk"})
    void validateFiveCharactersOrLess(String name) {
        //given & when & then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(CarNameLengthException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 빈 문자열일 경우, 예외를 발생시킨다.")
    @ValueSource(strings = {"", " ", "   "})
    void validateNonBlankName(String name) {
        //given & when & then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(NonBlankCarNameException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 빈 문자열일 경우, 예외를 발생시킨다.")
    @ValueSource(strings = {"a ", "a b", "a b c", " ab", "ab "})
    void validateNameWithoutWhiteSpace(String name) {
        //given & when & then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(CarNameContainsWhiteSpaceException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름에 공백이 포함될 경우, 예외를 발생시킨다.")
    @ValueSource(strings = {"a ", "a b", "a b c", " ab", "ab "})
    void validateNotContainSpaces(String name) {
        //given & when & then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(CarNameContainsWhiteSpaceException.class);
    }
}