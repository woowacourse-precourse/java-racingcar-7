package racingcar;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Race;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class RaceTest {
    private List<Car> cars;
    private int trial = 3;
    private Race race;


    @BeforeEach
    void 테스트를_위한_레이스_객체_초기화() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        cars = new ArrayList<>(List.of(pobi, woni, jun));

        race = new Race(cars, trial);
    }

    @Test
    void 우승자_판별() {
        List<Car> carsInRacing = race.getCars();

        assertRandomNumberInRangeTest(() -> {
            Car pobi = carsInRacing.stream()
                    .filter(car -> car.getName() == "pobi")
                    .findFirst()
                    .get();

            pobi.drive();
            race.getWinner();
        }, 4, 9);
    }
}
