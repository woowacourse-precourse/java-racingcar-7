package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @DisplayName("이름이 5자 이하면 자동차를 생성할 수 있다.")
    @Test
    void createCarWithValidName() {
        // given
        String name = "woowa";

        // when
        RacingCar racingCar = new RacingCar(name);

        // then
        assertThat(racingCar)
                .extracting("name", "position")
                .contains(name, 0);
    }

    @DisplayName("자동차 이름이 5보다 길면 예외가 발생한다.")
    @Test
    void createCarWithInvalidLengthName() {
        // given
        String name = "woowa1";

        // when & then
        assertThatThrownBy(() -> new RacingCar(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 길이는 5이하여야 합니다.");
    }

    @DisplayName("자동차 이름이 비어있으면 예외가 발생한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void createCarWithNullOrEmptyName(String name) {
        // when & then
        assertThatThrownBy(() -> new RacingCar(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @DisplayName("자동차 이름에 공백이 포함되어 있으면 예외가 발생한다.")
    @ValueSource(strings = {
            "a ",
            " a",
            "a a"
    })
    @ParameterizedTest
    void createCarWithContainsWhitespaceName(String name) {
        // when & then
        System.out.println(":" + name + ":");
        assertThatThrownBy(() -> new RacingCar(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백이 포함될 수 없습니다.");
    }

    @DisplayName("4 이상의 값으로 자동차를 움직일 수 있다.")
    @Test
    void attemptMoveWithGraterThanOrEqual4() {
        // given
        RacingCar racingCar = new RacingCar("car1");

        // when
        racingCar.attemptMove(4);

        // then
        assertThat(racingCar).extracting("position").isEqualTo(1);
    }

    @DisplayName("4 미만의 값은 자동차를 움직일 수 없다.")
    @Test
    void attemptMoveWithLessThan4() {
        // given
        RacingCar racingCar = new RacingCar("car1");

        // when
        racingCar.attemptMove(3);

        // then
        assertThat(racingCar).extracting("position").isEqualTo(0);
    }

    @DisplayName("특정 위치에 자동차가 있는지 확인할 수 있다.")
    @Test
    void isSamePosition() {
        // given
        int position = 3;
        RacingCar racingCar = new RacingCar("car1", position);

        // when
        boolean result = racingCar.isSamePosition(position);

        // then
        assertThat(result).isTrue();
    }

}
