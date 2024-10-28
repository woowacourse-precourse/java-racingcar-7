package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

class RacingCarServiceTest {
    private RacingCarService racingCarService = new RacingCarService(new InputView(), new OutputView());

    @DisplayName("최대값인 자동차들의 이름을 반환")
    @Test
    void getResultTest() {
        RacingCar car1 = new RacingCar("car1");
        RacingCar car2 = new RacingCar("car2");
        RacingCar car3 = new RacingCar("car3");

        car1.goAhead(6);
        car1.goAhead(6);

        car2.goAhead(6);

        car3.goAhead(6);

        List<RacingCar> cars = new ArrayList<>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<String> result =racingCarService.getResult(cars);
        Assertions.assertThat(result.size()).isEqualTo(1);
        Assertions.assertThat(result).contains("car1");

        car2.goAhead(6);

        List<String> result2 =racingCarService.getResult(cars);
        Assertions.assertThat(result2.size()).isEqualTo(2);
        Assertions.assertThat(result2).contains("car1","car2");

    }

}