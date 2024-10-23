package racingcar.model;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;
import racingcar.constant.MovementCondition;

class CarTest {

    @DisplayName("자동차는 전진을 결정할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"3,4", "2,5", "1,6", "0,7"})
    void decideMoveForward(int numberToStop, int numberToForward) {
        Car car = Car.from("test");
        assertAll(
                () -> assertThat(car.decideToMove(numberToStop)).isEqualTo(MovementCondition.STOP),
                () -> assertThat(car.decideToMove(numberToForward)).isEqualTo(MovementCondition.FORWARD)
        );
    }

    @DisplayName("자동차의 이름은 1자 이상, 5자 이하이다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "bbbbbbbbbb", "", "\n", "\t", " "})
    void nameLengthBetween1And5(String name) {
        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH.getMessage());
    }

    @DisplayName("자동차의 이름의 시작과 끝에 공백이 있으면 제거한다.")
    @ParameterizedTest
    @ValueSource(strings = {"  pobi   ", "   \t    woni    \n  ", "      \t\n jun \n\t     "})
    void trimName(String name) {
        String trimName = name.trim();
        assertThat(Car.from(name).getName()).isEqualTo(trimName);
    }

    @DisplayName("자동차의 이름 사이에 공백이 올 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"po bi", "w\toni", "ju\nn"})
    void noSpaceBetweenName(String name) {
        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_SPACE.getMessage());
    }
}