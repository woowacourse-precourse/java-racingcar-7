package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.entity.Car;
import racingcar.executor.util.DataConverter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DataConverterTest {

    @Test
    public void convertFromCarNameListToCar_ShouldReturnListOfCars_WhenInputIsValid() {
        String[] carNames = {"Car1", "Car2", "Car3"};

        List<Car> carList = DataConverter.convertFromCarNameListToCarList(carNames);

        assertThat(carList).hasSize(3);
        assertThat(carList)
                .extracting(Car::getCarName)
                .containsExactly("Car1", "Car2", "Car3");
        assertThat(carList)
                .extracting(Car::getDistance)
                .containsOnly(0);
    }

    @Test
    public void convertFromCarNameListToCar_ShouldReturnEmptyList_WhenInputIsEmpty() {
        String[] carNames = {};

        List<Car> carList = DataConverter.convertFromCarNameListToCarList(carNames);

        assertThat(carList).isEmpty(); // 리스트가 비어있는지 확인
    }
}

