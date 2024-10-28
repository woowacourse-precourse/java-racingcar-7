package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.extractor.CarNameExtractor;
import racingcar.factory.CarFactory;
import racingcar.validator.CarNameValidator;

class CarManagerTest {

    private final CarManager carManager;

    public CarManagerTest() {
        CarNameValidator carNameValidator = new CarNameValidator();
        CarNameExtractor carNameExtractor = new CarNameExtractor();
        CarFactory carFactory = new CarFactory();

        carManager = new CarManager(carNameValidator, carNameExtractor, carFactory);
    }

    @Test
    void 기본_문자열_처리() {
        String inputCarNames = "car1,car2,car3";

        List<Car> cars = carManager.processCarName(inputCarNames);

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }

    @Test
    void 공백_포함_입력() {
        String inputCarNames = "car1 ,  car2   ,car3";

        List<Car> cars = carManager.processCarName(inputCarNames);

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }
}