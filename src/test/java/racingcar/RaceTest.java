package racingcar;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;
import racingcar.race.Race;
import racingcar.race.Rule;

public class RaceTest {

    @Test
    void 레이스_지정된_라운드_수만큼_진행되는지_테스트() {
        Race race = new Race();
        List<Car> cars = Arrays.asList(
                new Car("bmw"),
                new Car("audi")
        );
        int numOfRounds = 3;

        race.startRace(cars, numOfRounds);

        for (Car car : cars) {
            Assertions.assertThat(car.getPosition()).isBetween(0, numOfRounds);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 숫자가_4_이상일_경우_이동가능_테스트(int number) {
        Rule rule = new Rule();
        Assertions.assertThat(rule.canMove(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 숫자가_4_미만일_경우_이동불가능_테스트(int number) {
        Rule rule = new Rule();
        Assertions.assertThat(rule.canMove(number)).isFalse();
    }
}
