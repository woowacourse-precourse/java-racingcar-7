package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.Race.shouldMove;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

public class RaceTest extends NsTest {

    @Test
    void shouldMove_유효테스트(){
        assertRandomNumberInRangeTest(
                () -> assertThat(shouldMove()).isTrue(),
                5, 3
        );
        assertRandomNumberInRangeTest(
                () -> assertThat(shouldMove()).isFalse(),
                2, 3
        );
    }

    @Test
    void runCarOnce_우승자1명_유효테스트()  {
        Car car1 = new Car("Adam");
        Car car2 = new Car("Ivan");
        car1.moveForward();
        car1.moveForward();
        car2.moveForward();

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        List<Car> winners = Race.getWinner(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners).extracting(Car::getCarName)
                .containsExactlyInAnyOrder("Adam");
    }

    @Test
    void runCarOnce_우승자다수_유효테스트()  {
        Car car1 = new Car("Adam");
        Car car2 = new Car("Ivan");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        List<Car> winners = Race.getWinner(cars);

        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getCarName)
                .contains("Adam", "Ivan");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
