package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceControllerTest extends NsTest {
    private RaceController raceController;

    @BeforeEach
    void setUp() {
        this.raceController = new RaceController();
    }

    private List<Car> createCars(String... names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.createDefaultCar(name));
        }
        return cars;
    }

    @Test
    @DisplayName("단독 우승자를 선정한다")
    void selectSingleWinner() {
        List<Car> cars = createCars("pobi", "jun");
        cars.get(1).setPosition(1);
        assertThat(raceController.selectWinners(cars)).isEqualTo(List.of("jun"));
    }

    @Test
    @DisplayName("공동 우승자를 출력한다")
    void selectMultiWinners() {
        List<Car> cars = createCars("pobi", "jun");
        assertThat(raceController.selectWinners(cars)).isEqualTo(List.of("pobi", "jun"));
    }

    @Override
    protected void runMain() {

    }
}