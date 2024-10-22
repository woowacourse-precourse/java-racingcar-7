package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {
    private static final int MOVED = 1;
    private static final int NOT_MOVED = 0;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private List<Car> carList;

    @BeforeEach
    void setup() {
        carList = List.of(
                Car.of("pobi"),
                Car.of("woni"),
                Car.of("corpi")
        );
    }

    @DisplayName("자동차는 전진할 수 있다.")
    @MethodSource("carMovement")
    @ParameterizedTest
    void moveIfPossible(List<Integer> carMovement, List<Integer> result) {
        // when
        assertRandomNumberInRangeTest(() -> {
            carList.forEach(Car::moveIfPossible);
        }, carMovement.getFirst(), carMovement.subList(1, carMovement.size()).toArray(new Integer[0]));

        // then
        List<Integer> carPositionList = carList.stream().map(Car::getPosition).toList();
        Assertions.assertThatCollection(carPositionList).isEqualTo(result);
    }

    private static Stream<Arguments> carMovement() {
        List<List<Integer>> carMovement = List.of(
                List.of(MOVING_FORWARD, MOVING_FORWARD, STOP),
                List.of(STOP, STOP, STOP)
        );
        List<List<Integer>> result = List.of(
                List.of(MOVED, MOVED, NOT_MOVED),
                List.of(NOT_MOVED, NOT_MOVED, NOT_MOVED)
        );

        return IntStream.range(0, carMovement.size())
                .mapToObj(index -> Arguments.of(carMovement.get(index), result.get(index)));
    }
}