package racingcar.model.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.model.domain.Car;
import racingcar.model.domain.CarList;
import racingcar.model.dto.GameResult;
import setup.TestCar;
import setup.TestCarList;

import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarRacingGameTest extends NsTest {

    CarList testCarList;
    CarRacingGame game;
    GameResult gameResult;

    static final String carName = "테스트카";
    static final int MOVING_FORWARD = 1;
    static final int STOP = 4;

    @BeforeEach
    void setUp() {
        List<Car> carList = IntStream.range(0, 3)
                .mapToObj(i -> TestCar.getTestCar(carName + i))
                .toList();
        testCarList = TestCarList.getTestCarList(carList);

        gameResult = new GameResult();
        game = new CarRacingGame();

    }

    @Test
    @DisplayName("게임을 시작하면 난수를 뽑고 판별 후 거리를 증가시키며 저장한다.")
    void start() {
        int size = 3;
        assertRandomNumberInRangeTest(
                () -> {
                    game.play(gameResult, testCarList, size);
                    assertThat(gameResult.getRoundResult().get(size - 1).getResultList().getFirst()).contains("테스트카0 : --\n");
                    assertThat(gameResult.getRoundResult().size()).isEqualTo(size);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("결과를 출력할 시 가장 멀리 간 자동차를 뽑아 저장한다.")
    void result() {
        int size = 3;
        assertRandomNumberInRangeTest(
                () -> {
                    game.play(gameResult, testCarList, size);
                    game.determineWinner(gameResult, testCarList);
                    assertThat(gameResult.getWinner()).contains("테스트카1, 테스트카2");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}