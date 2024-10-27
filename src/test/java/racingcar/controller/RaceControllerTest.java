package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceControllerTest extends NsTest {
    private RaceController raceController = new RaceController();

    @Test
    @DisplayName("단독 우승자를 선정한다")
    void selectSingleWinner() {
        Car car = new Car("pobi");
        Car car2 = new Car("jun");
        car2.setPosition(1);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car2);
        assertThat( raceController.selectWinners(cars)).isEqualTo(List.of("jun"));
    }

    @Test
    @DisplayName("공동 우승자를 출력한다")
    void selectMultiWinners() {
        Car car = new Car("pobi");
        Car car2 = new Car("jun");
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car2);
        assertThat( raceController.selectWinners(cars)).isEqualTo(List.of("pobi", "jun"));
    }

    @Override
    protected void runMain() {

    }
}