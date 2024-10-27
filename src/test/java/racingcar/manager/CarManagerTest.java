package racingcar.manager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.entity.Car;

class CarManagerTest {
    CarManager carManager;

    @BeforeEach
    void setUp() {
        carManager = new CarManager();
    }

    @Test
    void 경주_자동차_리스트_생성() {
        String[] carNames = {"car1", "car2", "car3"};
        List<Car> carList = carManager.carNamesToCarList(carNames);

        assertThat(carList).isNotEmpty();
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            assertThat(car.getCarName()).isEqualTo(carNames[i]);
        }
    }
}