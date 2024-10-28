package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.RacingGameService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameServiceTest {

    private final RacingGameService racingGameService = new RacingGameService();

    @Test
    void createCars_createsCarsSuccessfully() {
        String input = "cara,carb,carc";
        racingGameService.createCars(input);

        List<Car> cars = racingGameService.getCars();
        assertThat(cars).hasSize(3); // 자동차가 3개 생성되어야 함
        assertThat(cars.get(0).getName()).isEqualTo("cara");
        assertThat(cars.get(1).getName()).isEqualTo("carb");
        assertThat(cars.get(2).getName()).isEqualTo("carc");
    }
}

