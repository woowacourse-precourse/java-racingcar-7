package racingcar;

import static racingcar.Car.createDefaultCar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.FakeGenerator;

class RacingTest {

    private Racing racing;

    @DisplayName("우승자를 정확히 구하는지 확인한다")
    @Test
    void racingTest1() {
        //given
        String carName1 = "car1";
        String carName2 = "car2";
        String carName3 = "car3";

        Car car1 = createDefaultCar(carName1);
        Car car2 = createDefaultCar(carName2);
        Car car3 = createDefaultCar(carName3);
        car1.move(new FakeGenerator(100));
        car2.move(new FakeGenerator(2));
        car3.move(new FakeGenerator(3));

        racing = new Racing(Cars.from(carName1 + "," + carName3 + "," + carName3));

        List<String> winners = racing.findWinners();
        Assertions.assertThat(winners.size()).isEqualTo(1);
        Assertions.assertThat(winners.get(0)).isEqualTo("Car1");
    }

}
