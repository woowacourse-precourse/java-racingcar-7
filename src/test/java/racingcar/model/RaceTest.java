package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.MoveDecider;
import racingcar.utils.TestRandomNumberGenerator;

class RaceTest {

    private Race race;
    private Cars cars;
    private MoveDecider moveDecider;

    private final List<String> carList = List.of("pobi", "woni", "jun");

    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.addCars(carList);
    }

    @Test
    @DisplayName("차량 움직이는 경우")
    void startRound_AllCarsMove() {
        moveDecider = new MoveDecider(new TestRandomNumberGenerator(4));
        race = new Race(cars, moveDecider);

        List<Car> roundStatus = race.startRound();

        assertTrue(roundStatus.stream().allMatch(car -> car.getDistance() > 0));
    }

    @Test
    @DisplayName("우승자 판별")
    void determineFinalWinner_All_Winner() {
        moveDecider = new MoveDecider(new TestRandomNumberGenerator(4));
        race = new Race(cars, moveDecider);

        race.startRound();

        race.determineFinalWinner();

        assertEquals(carList, race.getFinalWinners());
    }
}