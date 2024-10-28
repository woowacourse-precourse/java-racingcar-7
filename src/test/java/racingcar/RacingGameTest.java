package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void 자동차_초기화_확인() {
        String[] carNames = {"car1", "car2", "car3"};
        racingGame.initializeCars(carNames);

        assertThat(racingGame.getCars()).hasSize(3);
        assertThat(racingGame.getCars())
                .extracting(Car::getName)
                .containsExactly("car1", "car2", "car3");
    }

    @Test
    void 모든_자동차_전진_시도() {
        String[] carNames = {"car1", "car2"};
        racingGame.initializeCars(carNames);

        // 무작위 조건 만족 시 자동차가 전진
        racingGame.attemptAllCarsMove();

        racingGame.getCars().forEach(car ->
                assertThat(car.getPosition()).isGreaterThanOrEqualTo(0)
        );
    }

    @Test
    void 우승자_결정_테스트() {

        String[] carNames = {"car1", "car2", "car3"};
        racingGame.initializeCars(carNames);

        racingGame.getCars().get(0).move();
        racingGame.getCars().get(1).move();
        racingGame.getCars().get(1).move();
        racingGame.getCars().get(2).move();

        List<String> winners = racingGame.findWinners();
        assertThat(winners).containsExactly("car2");
    }



    @Test
    void 자동차_이름_목록_비어있을_때_예외처리() {
        // null 배열 예외
        assertThatThrownBy(() -> racingGame.initializeCars(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 목록이 비어 있습니다.");

        // 빈 배열 예외
        assertThatThrownBy(() -> racingGame.initializeCars(new String[0]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 목록이 비어 있습니다.");
    }

}