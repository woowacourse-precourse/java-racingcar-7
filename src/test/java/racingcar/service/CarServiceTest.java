package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.ErrorMessage;

class CarServiceTest {

    private final CarService carService = new CarService();

    @Test
    @DisplayName("자동차 이름을 쉼표로 구분하여 리스트로 생성해야 한다.")
    void createCars_shouldReturnListOfCars() {
        // Given
        String carsName = "pobi, woni, jun";

        // When
        List<Car> cars = carService.createCars(carsName);

        // Then
        assertThat(cars).hasSize(3);
        assertThat(cars).extracting("name").containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우 예외가 발생해야 한다.")
    void createCars_shouldThrowExceptionForDuplicateNames() {
        // Given
        String carsName = "pobi, woni, pobi";

        // When & Then
        assertThatThrownBy(() -> carService.createCars(carsName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_DUPLICATED.message());
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열일 경우 예외가 발생해야 한다.")
    void createCars_shouldThrowExceptionForEmptyNames() {
        // Given
        String carsName = "";

        // When & Then
        assertThatThrownBy(() -> carService.createCars(carsName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_DUPLICATED.message());
    }

    @Test
    @DisplayName("자동차 이름이 공백으로만 이루어져 있을 경우 예외가 발생해야 한다.")
    void createCars_shouldThrowExceptionForWhitespaceNames() {
        // Given
        String carsName = "   ";

        // When & Then
        assertThatThrownBy(() -> carService.createCars(carsName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_DUPLICATED.message());
    }
}
