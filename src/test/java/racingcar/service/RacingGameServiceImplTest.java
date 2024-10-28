package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.validation.CarNamesValidatorImpl;

class RacingGameServiceImplTest {
    private RacingGameServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new RacingGameServiceImpl(new CarNamesValidatorImpl(), () -> 5);
    }

    @Test
    @DisplayName("자동차 이름 리스트로 경주 자동차 초기화 테스트")
    void 자동차_초기화_테스트() {
        String input = "pobi,woni,jun";
        List<Car> cars = service.splitAndInitializeRacingCars(input);

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    @DisplayName("경주 후 최종 우승자 결정 테스트")
    void 우승자_결정_테스트() {
        List<Car> cars = service.splitAndInitializeRacingCars("pobi,woni,jun");

        cars.get(0).move(5);
        cars.get(1).move(3);
        cars.get(2).move(5);

        List<String> winners = service.getWinners(cars);
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }
}