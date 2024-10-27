package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;

class CarFactoryTest {

    @DisplayName("자동차 이름을 가지고 자동차 객체들을 생성하는 테스트")
    @Test
    void makeCarsTest() {
        CarFactory carFactory = new CarFactory();
        List<String> carNames = List.of("genesis", "bmw", "bentley", "hybrid");
        List<Car> cars = carFactory.makeCars(carNames);

        assertThat(cars.size()).isEqualTo(4);
        for(int i = 0; i < carNames.size(); i++) {
            assertThat(cars.get(i).getCarName()).isEqualTo(carNames.get(i));
        }
    }

}