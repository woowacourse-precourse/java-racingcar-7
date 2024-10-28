package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class RacingCarServiceTest {

    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
    }

    @Test
    @DisplayName("자동차 이름 목록을 받아 해당 이름으로 구성된 자동차 객체 리스트를 생성한다.")
    void initializeCarsByCarNames() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");

        // when
        List<Car> cars = racingCarService.initializeCars(carNames);

        // then
        assertThat(cars).hasSize(carNames.size());
        assertThat(cars).extracting(Car::getName).containsExactlyElementsOf(carNames);
    }

    @Test
    @DisplayName("각 자동차가 0에서 9 사이의 랜덤 숫자에 따라 이동하도록 한다.")
    void moveCarsByRandomNumber() {
        // given
        List<Car> carList = racingCarService.initializeCars(Arrays.asList("pobi", "woni", "jun"));

        // when
        racingCarService.moveCars(carList);

        // then
        assertThat(carList).allMatch(car -> car.getPosition() >= 0 && car.getPosition() <= 1);
    }

    @Test
    @DisplayName("자동차 목록에서 가장 멀리 이동한 자동차 이름을 우승자로 반환한다.")
    void determineWinners() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        car1.move();
        car1.move();
        car2.move();
        car3.move();
        car3.move();

        List<Car> carList = Arrays.asList(car1, car2, car3);

        // when
        List<String> winners = racingCarService.determineWinners(carList);

        // then
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }
}
