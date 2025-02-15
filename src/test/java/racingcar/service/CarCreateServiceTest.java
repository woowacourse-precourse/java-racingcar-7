package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

@DisplayName("CarCreateService 테스트")
public class CarCreateServiceTest {

    private CarCreateService carCreateService;

    @BeforeEach
    void setup() {
        carCreateService = new CarCreateService();
    }

    @Test
    void 문자열로_자동차_리스트를_생성한다() {
        //given
        String carNames = "pobi,woni,jun";

        //when
        Cars cars = carCreateService.fromString(carNames);

        //then
        assertThat(cars.size()).isEqualTo(3);
    }
}
