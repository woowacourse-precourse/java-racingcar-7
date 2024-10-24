package racingcar.car;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RacingCarsTest {

    private static Stream<Arguments> provideCarNamesForCarsSize() {
        return Stream.of(
                Arguments.of(List.of("pobi", "woni", "jun"), 3),
                Arguments.of(List.of("pobi"), 1)
        );
    }

    @DisplayName("fromName 함수를 이용해 RacingCars 객체를 생성한다.")
    @MethodSource("provideCarNamesForCarsSize")
    @ParameterizedTest()
    void fromNames(List<String> carNames, int carsSize) {
        // when
        RacingCars racingCars = RacingCars.fromNames(carNames);

        // then
        assertThat(racingCars.getCars()).hasSize(carsSize);
    }

    @DisplayName("")
    @TestFactory
    Collection<DynamicTest> getWinnersName() {
        // given
        RacingCars racingCars = RacingCars.fromNames(List.of("car1", "car2"));

        return List.of(
                DynamicTest.dynamicTest("공동 우승자이다", () -> {

                    // when
                    List<String> winnersName = racingCars.getWinnersName();

                    // then
                    assertThat(winnersName).containsExactlyInAnyOrder("car1", "car2");
                }),
                DynamicTest.dynamicTest("car1이 단독 우승자이다", () -> {
                    // given
                    List<RacingCar> cars = racingCars.getCars();
                    cars.forEach(car -> {
                        if (car.getName().equals("car1")) {
                            car.increaseMoveCount();
                        }
                    });

                    // when
                    List<String> winnersName = racingCars.getWinnersName();

                    // then
                    assertThat(winnersName).containsExactly("car1");
                })

        );
    }

}