package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.config.AppConfig;
import racingcar.model.car.Car;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.Error.NOT_DUPLICATED_NAME;
import static racingcar.model.movement.RandomMovement.MOVE_MIN_NUMBER;

class RacingTest {
    private AppConfig appConfig = new AppConfig();

    @ParameterizedTest
    @MethodSource("provideDuplicatedCarName")
    void 자동차_이름_중복_예외(String carName1, String carName2, String carName3) {
        List<Car> cars
                = appConfig.carFactory().produceCars(List.of(carName1, carName2, carName3));
        assertThatThrownBy(() -> Racing.of(cars, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DUPLICATED_NAME.getMessage());
    }

    private static Stream<Arguments> provideDuplicatedCarName() {
        return Stream.of(
                Arguments.of("a", "b", "b"),
                Arguments.of("a", "b", "a"),
                Arguments.of("aaaa", "aaa", "aaaa")
        );
    }

    @Test
    void 우승자_판별() {
        //given
        List<String> carNames = List.of("a", "b", "c");
        List<Car> cars = appConfig.carFactory().produceCars(carNames);
        Racing racing = Racing.of(cars, 3);

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    racing.start();
                },
                MOVE_MIN_NUMBER, MOVE_MIN_NUMBER, MOVE_MIN_NUMBER,
                MOVE_MIN_NUMBER, MOVE_MIN_NUMBER, MOVE_MIN_NUMBER,
                MOVE_MIN_NUMBER - 1, MOVE_MIN_NUMBER, MOVE_MIN_NUMBER
        );

        //then
        List<Car> winners = racing.getWinners();
        assertThat(winners.get(0).getName()).isEqualTo("b");
        assertThat(winners.get(1).getName()).isEqualTo("c");
    }
}