package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("자동차 이름을 정상적으로 추가한다.")
    @Test
    public void addCars_ValidNames_ShouldAddCars() {
        Cars cars = new Cars("pobi,woni,jun");
        List<Car> carList = cars.getCars();

        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("jun");
    }

    @DisplayName("자동차들의 이름이 비어있을 경우 예외가 발생한다.")
    @Test
    public void addCars_EmptyName_ShouldThrowException() {
        assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
    }

    @DisplayName("자동차들의 수가 2대 미만일 경우 예외가 발생한다.")
    @Test
    public void addCars_InsufficientCars_ShouldThrowException() {
        assertThatThrownBy(() -> new Cars("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INSUFFICIENT_CARS.getMessage());
    }

    @DisplayName("중복된 자동차 이름이 있을 경우 예외가 발생한다.")
    @Test
    public void addCars_DuplicateNames_ShouldThrowException() {
        assertThatThrownBy(() -> new Cars("pobi,woni,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_CAR_NAMES.getMessage());
    }
}