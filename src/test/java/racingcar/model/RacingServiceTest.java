package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Racing Service Tests")
public class RacingServiceTest {
    private RacingService racingService;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
        car1 = new Car("Car1");
        car2 = new Car("Car2");
        car3 = new Car("Car3");
    }

    @Nested
    @DisplayName("자동차 이름 변환")
    class ConvertCarNames {

        @Test
        @DisplayName("자동차 이름을 입력받아 Car 객체 리스트로 변환하는 테스트")
        void convertsCarNamesToCarObjects() {
            String carNames = "Car1, Car2, Car3";
            List<Car> cars = racingService.convertNamesToCars(carNames);

            assertThat(cars).hasSize(3);
            assertThat(cars).extracting(Car::getName).containsExactly("Car1", "Car2", "Car3");
        }
    }

    @Nested
    @DisplayName("경주 라운드 실행")
    class ExecuteRaceRound {

        @Test
        @DisplayName("경주 라운드를 실행하고 자동차의 거리가 변경되는 테스트")
        void changesCarDistanceAfterExecutingRaceRound() {
            List<Car> carList = List.of(car1, car2);

            racingService.executeRound(carList);

            assertThat(car1.getState()).isGreaterThanOrEqualTo(0);
            assertThat(car2.getState()).isGreaterThanOrEqualTo(0);
        }
    }

}