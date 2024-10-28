package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.Car;
import racingcar.executor.util.DataConverter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DataConverterTest {

    @DisplayName("제대로 입력한 자동차 이름 문자열을 쉼표를 기준으로 쪼개서 반환해주는지 Test")
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

    @DisplayName("변환하는 과정에서 빈 자동차 이름 배열을 보냈을 떄 빈 배열을 반환하는지 Test")
    @Test
    public void convertFromCarNameListToCar_ShouldReturnEmptyList_WhenInputIsEmpty() {
        String[] carNames = {};

        List<Car> carList = DataConverter.convertFromCarNameListToCarList(carNames);

        assertThat(carList).isEmpty();
    }
}

