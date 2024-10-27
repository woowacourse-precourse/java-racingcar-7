package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.util.FixedMoveStrategy;

public class RacingGameServiceTest {
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        // 테스트용 자동차 리스트 설정
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("loopy");
        List<Car> cars = List.of(car1, car2, car3);

        // 항상 이동하도록 설정된 이동 전략 사용
        FixedMoveStrategy moveStrategy = new FixedMoveStrategy(true);
        racingCars = new RacingCars(cars, moveStrategy);
    }

    @Test
    @DisplayName("단일 우승자 테스트")
    void singleWinnerTest() {
        // given
        RacingGameService racingGameService = new RacingGameService(racingCars);

        // 모두 2번 이동시킨 후 추가적으로 pobi 한번 더 이동
        racingGameService.playRound();
        racingGameService.playRound();
        racingCars.getCars().get(0).moveForward();

        // when
        List<String> winners = racingGameService.getWinners();

        // then (pobi 단독 우승)
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("공동 우승자 테스트")
    void muiltiWinnerTest() {
        // given
        RacingGameService racingGameService = new RacingGameService(racingCars);

        // 두 번 이동하여 공동 우승자로 설정
        racingGameService.playRound();
        racingGameService.playRound();

        // when
        List<String> winners = racingGameService.getWinners();

        // then (모두가 공동 우승)
        assertThat(winners).containsExactlyInAnyOrder("pobi", "crong", "loopy");
    }
}
