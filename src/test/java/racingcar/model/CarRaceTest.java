package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {
    private List<Car> cars;
    private CarRace carRace;

    private static class FixedRandomGenerator implements RandomGenerator {
        private final int fixedValue;

        public FixedRandomGenerator(int fixedValue) {
            this.fixedValue = fixedValue;
        }

        @Override
        public int pickNumber(int bound) {
            return fixedValue;
        }
    }

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("a"), new Car("b"), new Car("c"));
    }

    @Test
    void 자동차_경주_진행_테스트() {
        carRace = new CarRace(cars, new FixedRandomGenerator(4));
        carRace.runRace();
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);

    }

    @Test
    void 우승자_목록_테스트() {
        carRace = new CarRace(cars, new FixedRandomGenerator(4));
        carRace.runRace();

        List<String> winners = carRace.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("a", "b", "c");

    }

    @Test
    void 우승자가_여러명인_경우_테스트() {
        carRace = new CarRace(cars, new RandomGenerator() {
            private final int[] numbers = {3, 4, 4};
            private int index = 0;

            @Override
            public int pickNumber(int bound) {
                return numbers[index++];
            }
        });

        carRace.runRace();

        List<String> winners = carRace.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("b", "c");
    }

    @Test
    void 우승자가_한명인_경우_테스트() {
        carRace = new CarRace(cars, new RandomGenerator() {
            private final int[] numbers = {4, 3, 3};
            private int index = 0;

            @Override
            public int pickNumber(int bound) {
                return numbers[index++ % numbers.length];
            }
        });

        carRace.runRace();

        List<String> winners = carRace.getWinners();
        assertThat(winners).containsExactly("a"); // car1이 유일한 우승자
    }
}