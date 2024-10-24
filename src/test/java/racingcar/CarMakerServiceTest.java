package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarMakerService;
import racingcar.validator.CarNameValidator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarMakerServiceTest {

    @DisplayName("자동차 이름이 유효한 경우 자동차를 생성한다.")
    @Test
    void makeCars(){
        // Arrange
        String[] carNames = {"car1", "car2", "car3"};
        CarMakerService carMakerService = new CarMakerService();

        //Act
        List<Car> cars = carMakerService.makeCars(carNames);

        //Assert
        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
        assertEquals("car3", cars.get(2).getName());
    }
}
