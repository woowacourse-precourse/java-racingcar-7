package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarServiceTest {

    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
    }

    @Test
    void 시도_횟수만큼_경기_반복() {
        // given
        List<Car> cars = Arrays.asList(new Car("car1"));
        Race race = new Race(cars);
        int attemptCount = 5;

        // when
        racingCarService.startRace(race, attemptCount);

        // then
        assertThat(race.getNumOfMatches()).isEqualTo(attemptCount);
        assertThat(cars.get(0).getPosition()).isBetween(0, attemptCount);
    }

    @Test
    void 모든_차들을_조건에_따라_전진() {
        // given
        List<Car> cars = Arrays.asList(new Car("Car1"), new Car("Car2"));

        // when
        racingCarService.raceCars(cars);

        // then
        assertThat(cars.get(0).getPosition()).isBetween(0, 1);
        assertThat(cars.get(1).getPosition()).isBetween(0, 1);
    }

    @Test
    void 우승자가_자동차_한_대인_경우() {
        // given
        Car car1 = new Car("Car1", 5);
        Car car2 = new Car("Car2", 4);
        Car car3 = new Car("Car3", 3);
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        List<String> namesOfWinners = racingCarService.getWinners(cars);

        // then
        assertThat(namesOfWinners).containsExactly("Car1");
    }
}
