package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarsTest {

    @ParameterizedTest
    @MethodSource("provideNameAndResultCars")
    public void 이름을_컴마로_분리하여_자동차들을_생성한다(String names, List<Car> cars) {
        assertThat(Cars.from(names)).isEqualTo(new Cars(cars));
    }

    static Stream<Arguments> provideNameAndResultCars() {
        return Stream.of(
                arguments("pobi", List.of(new Car("pobi")),
                        arguments("pobi,jihun", List.of(new Car("jihun"), new Car("pobi")))
                ));
    }

    @Test
    public void 모든자동차를_이동한다() {
        Cars cars = new Cars(createTwoCars(1, 0));

        Cars result = cars.move(new EvenNumberMoveCommander());

        assertThat(result).isEqualTo(new Cars(createTwoCars(2, 0)));
    }

    private static List<Car> createTwoCars(int position1, int position2) {
        return carsFixture(new Car("test1", position1), new Car("test2", position2));
    }

    private static List<Car> carsFixture(Car... cars) {
        return Arrays.asList(cars);
    }

    private static class EvenNumberMoveCommander implements MovementCommander {

        private int count = 0;

        @Override
        public MoveCommand moveCommand() {
            MoveCommand command = command();
            increaseCount();
            return command;
        }

        private void increaseCount() {
            count++;
        }

        private MoveCommand command() {
            if (isEven()) {
                return MoveCommand.MOVE;
            }
            return MoveCommand.STOP;
        }

        private boolean isEven() {
            return count % 2 == 0;
        }
    }
}
