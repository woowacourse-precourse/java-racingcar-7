package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.entity.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameServiceTest {
    private RacingGameService racingGameService;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        racingGameService = new RacingGameService();
        cars = racingGameService.createCars(List.of("pobi", "woni", "jun"));
    }

    @Test
    void 자동차_목록_생성_이름이_올바르게_설정되는지_확인() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        List<Car> createdCars = racingGameService.createCars(carNames);

        assertThat(createdCars).hasSize(3);
        assertThat(createdCars.get(0).getName()).isEqualTo("pobi");
        assertThat(createdCars.get(1).getName()).isEqualTo("woni");
        assertThat(createdCars.get(2).getName()).isEqualTo("jun");
    }
}
