package racingcar.model;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private static final int MOVING_FORWARD = 4;

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void 자동차_초기화_테스트() {
        String[] carNames = {"pobi", "woni", "jun"};
        racingGame.initCars(carNames);

        List<Car> cars = racingGame.getCars();
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 라운드_진행_테스트() {
        String[] carNames = {"pobi", "woni"};
        racingGame.initCars(carNames);

        racingGame.play();
        assertThat(racingGame.getCars().get(0).getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 우승자_찾기_테스트() {
        String[] carNames = {"pobi", "woni", "jun"};
        racingGame.initCars(carNames);

        // 특정 값으로 전진 조건을 만족하게 설정하여 pobi와 woni가 한 칸씩 전진
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    racingGame.getCars().get(0).move(); // pobi 전진
                    racingGame.getCars().get(1).move(); // woni 전진
                    List<Car> winners = racingGame.findWinners();

                    assertThat(winners).extracting(Car::getName).contains("pobi", "woni");
                },
                MOVING_FORWARD // 전진 조건을 만족하는 값 (4 이상)
        );
    }
}