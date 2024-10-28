package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RacingControllerTest {

    RacingController racingController;

    @BeforeEach
    void setUp() {
        racingController = new RacingController();
    }

    @Test
    @DisplayName("경주에 참여한 자동차의 위치 중 가장 큰 값(max)을 알아낸다")
    void testGetMaxCurrentLocation() {
        // given
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 4);
        Car car3 = new Car("car3", 4);
        racingController.cars = List.of(car1, car2, car3);

        // when
        int maxLocation = racingController.getMaxCurrentLocation();

        // then
        assertThat(maxLocation).isEqualTo(4);
    }

    @Test
    @DisplayName("max값과 현재 위치가 같은 자동차들을 우승자로 선정한다.")
    void testGetWinnerNames() {
        // given
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 4);
        Car car3 = new Car("car3", 4);
        racingController.cars = List.of(car1, car2, car3);

        // when
        List<String> winnerNames = racingController.getWinnerNames();

        // then
        assertThat(winnerNames).containsExactlyInAnyOrder("car2", "car3");
    }


}