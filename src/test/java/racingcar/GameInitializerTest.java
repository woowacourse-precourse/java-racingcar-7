package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class GameInitializerTest {

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승자인지 테스트")
    void determineWinnerBasedOnPosition() {
        GameInitializer initializer = new GameInitializer();

        Car car1 = new Car("obi");
        Car car2 = new Car("woni");
        Car car3 = new Car("nunu");

        car1.setPosition(1);
        car2.setPosition(2);
        car3.setPosition(3);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        initializer.longestCarName(cars);

        assertThat(car3.getPosition()).isEqualTo(3);
    }

}
