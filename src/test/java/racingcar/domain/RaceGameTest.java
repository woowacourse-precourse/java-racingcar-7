package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceGameTest {
    RaceGame raceGame;

    @BeforeEach
    void setup() {
        List<Car> cars = List.of(new Car("1"), new Car("2"), new Car("3"));
        GenerateNumberStrategy strategy = new MockGenerateNumberStrategy(List.of(4, 2, 2));
        raceGame = new RaceGame(cars, 3, strategy);
    }

    @Test
    void 주어진_횟수만큼_경기_후에_종료된다() {
        raceGame.run();

        assertThat(raceGame.isGameEnd()).isTrue();
    }

    @Test
    void 제일_많이_전진한_사람이_우승자이다() {
        raceGame.run();

        Car winner = raceGame.getWinner().getFirst();
        assertThat(winner.getMovement()).isEqualTo(3);
    }

    class MockGenerateNumberStrategy implements GenerateNumberStrategy {
        private final List<Integer> numbers;
        private int i = 0;

        MockGenerateNumberStrategy(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.get(i++ % numbers.size());
        }
    }
}