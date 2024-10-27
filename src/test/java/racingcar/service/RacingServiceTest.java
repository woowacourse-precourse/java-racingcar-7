package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.Car;
import racingcar.test_data_generator.CarGenerator;

class RacingServiceTest {

    private final RacingService racingService = new RacingService();

    @DisplayName("자동차 경주 진행 기능 - 한 라운드마다 n개의 자동차는 한번씩 전진 시도를 한다.")
    @ParameterizedTest(name = "3개의 자동차에 {0} 무작위 값이 주어졌을 경우 각 자동차의 전진 거리는 {1}")
    @MethodSource()
    public void 자동차_경주의_라운드_진행(List<Integer> randomNumberSet, List<Integer> expectedCarMovedDistance) {
        List<Car> givenCars = CarGenerator.makeCars(List.of("car1", "car2", "car3"));
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.processRound(givenCars);
                    assertThat(givenCars.get(0).getMovedDistance()).isEqualTo(expectedCarMovedDistance.get(0));
                    assertThat(givenCars.get(1).getMovedDistance()).isEqualTo(expectedCarMovedDistance.get(1));
                    assertThat(givenCars.get(2).getMovedDistance()).isEqualTo(expectedCarMovedDistance.get(2));
                },
                randomNumberSet.get(0), randomNumberSet.get(1), randomNumberSet.get(2)
        );
    }

    private static Stream<Arguments> 자동차_경주의_라운드_진행() {
        return Stream.of(
                Arguments.of(List.of(3, 3, 3), List.of(0, 0, 0)),
                Arguments.of(List.of(4, 4, 4), List.of(1, 1, 1)),
                Arguments.of(List.of(0, 0, 5), List.of(0, 0, 1))
        );
    }

    @DisplayName("자동차 경주 진행 기능 - 가장 많이 전진한 자동차들이 우승자")
    @ParameterizedTest(name = "우승자가 {1}일 경우")
    @MethodSource()
    public void 우승자_찾기(List<Car> givenCars, List<String> expectedWinnerNames) {
        List<Car> winners = racingService.findWinners(givenCars);
        List<String> actualWinnerNames = winners.stream().map(Car::getName).toList();
        assertThat(actualWinnerNames).containsExactlyElementsOf(expectedWinnerNames);
    }

    private static Stream<Arguments> 우승자_찾기() {
        return Stream.of(
                Arguments.of(CarGenerator.makeCars(List.of("r0", "r1", "r2"), List.of(5, 3, 2)), List.of("r0")),
                Arguments.of(CarGenerator.makeCars(List.of("r0", "r1", "r2"), List.of(5, 5, 1)), List.of("r0", "r1")),
                Arguments.of(CarGenerator.makeCars(List.of("r0", "r1", "r2"), List.of(5, 5, 5)),
                        List.of("r0", "r1", "r2"))
        );
    }
}