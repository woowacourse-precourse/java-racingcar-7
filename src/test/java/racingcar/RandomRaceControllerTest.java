package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomRaceControllerTest {
    private RandomRaceController randomRaceController;
    private List<RacingCar> racingCars;

    @BeforeEach
    void setUp() {
        this.randomRaceController = new RandomRaceController();
        this.racingCars = new ArrayList<>();
        racingCars.add(new RacingCar("pobi"));
        racingCars.add(new RacingCar("java"));
    }

    @Test
    void 시도횟수만큼_랜덤하게_전진한다() {
        List<RacingCar> newRacingCars = randomRaceController.start(racingCars, 2L);
        for (RacingCar racingCar : newRacingCars) {
            int distanceLength = racingCar.getDistance().length();
            assertThat(distanceLength).isBetween(0, 2);
        }
    }
}