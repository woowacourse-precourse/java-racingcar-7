package racingcar.Service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RegisterService;

public class RegisterServiceTest {
    @DisplayName("모든 차를 등록하는지 확인")
    @Test
    void registerAllCars() {
        String carNames = "pobi,woni,jun";
        RegisterService registerService = new RegisterService();

        Cars cars = registerService.registerCars(carNames);

        assertThat(cars.getCars())
                .extracting(Car::getName)       // 각 Car 객체의 이름을 추출
                .containsExactly("pobi", "woni", "jun");
    }
}
