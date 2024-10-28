package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.race.WinnerSelector;

public class WinnerTest {

    private WinnerSelector winnerSelector;

    @BeforeEach
    void setUp() {
        winnerSelector = new WinnerSelector();
    }

    @DisplayName("우승자 1명일 때 리스트 값도 1개")
    @Test
    void getSingleWinnerTest() {
        assertSimpleTest(() -> {

            Car car1 = new Car("한동근");
            Car car2 = new Car("두동근");
            List<Car> cars = List.of(car1,car2);

            car1.moveForward();

            List<Car> winner = winnerSelector.getWinners(cars);

            assertThat(winner).containsExactly(car1);
        });
    }

    @DisplayName("우승자 2명일 때 리스트 값도 2개")
    @Test
    void getDoubleWinnerTest() {
        assertSimpleTest(() -> {

            Car car1 = new Car("한동근");
            Car car2 = new Car("두동근");
            List<Car> cars = List.of(car1,car2);

            car1.moveForward();
            car2.moveForward();

            List<Car> winner = winnerSelector.getWinners(cars);

            assertThat(winner).containsExactly(car1, car2);
        });
    }

    @DisplayName("우승자 3명일 때 리스트 값도 3개")
    @Test
    void getTripleWinnerTest() {
        assertSimpleTest(() -> {
            Car car1 = new Car("한동근");
            Car car2 = new Car("두동근");
            Car car3 = new Car("세동근");
            List<Car> cars = List.of(car1,car2,car3);

            car1.moveForward();
            car2.moveForward();
            car3.moveForward();

            List<Car> winner = winnerSelector.getWinners(cars);

            assertThat(winner).containsExactly(car1, car2, car3);
        });
    }
}
