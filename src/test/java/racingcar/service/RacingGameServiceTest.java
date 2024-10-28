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

    @Test
    void 게임_시작_랜덤값이_조건을_충족할_경우_자동차_전진_확인() {
        int initialPositionSum = cars.stream().mapToInt(Car::getPosition).sum();
        racingGameService.startGame(cars, 1);
        int newPositionSum = cars.stream().mapToInt(Car::getPosition).sum();

        assertThat(newPositionSum).isGreaterThanOrEqualTo(initialPositionSum);
    }

    @Test
    void 우승자_가장_높은_위치의_자동차가_올바르게_선정되는지_확인() {
        // 자동차들의 위치를 임의로 설정합니다.
        cars.get(0).move();
        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();
        cars.get(2).move();

        List<String> winners = racingGameService.getWinners(cars);

        assertThat(winners).containsExactly("pobi", "jun");
    }
}
