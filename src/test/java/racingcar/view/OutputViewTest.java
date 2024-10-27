package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TestCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class OutputViewTest {
    @Test
    void 진행_상황_출력() {
        Car car1 = new TestCar("pobi", true);
        Car car2 = new TestCar("woni", false);

        Cars cars = new Cars(Arrays.asList(car1, car2));
        OutputView outputView = new OutputView(cars);

        int moveCount = 5;
        IntStream.range(0, moveCount).forEach(i -> cars.moveAll());

        assertThat(outputView.generateProgress()).isEqualTo("pobi : -----\nwoni : ");
    }

    @Test
    void 승자_출력() {
        Car car1 = new TestCar("pobi", true);
        Car car2 = new TestCar("woni", false);
        Car car3 = new TestCar("jun", true);

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        OutputView outputView = new OutputView(cars);

        int moveCount = 5;
        IntStream.range(0, moveCount).forEach(i -> cars.moveAll());

        assertThat(outputView.generateWinners()).isEqualTo("최종 우승자 : pobi, jun");
    }
}
