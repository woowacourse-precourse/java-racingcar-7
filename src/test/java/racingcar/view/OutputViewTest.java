package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.factory.GameFactory;
import racingcar.model.domain.Car;
import racingcar.model.domain.CarList;
import racingcar.model.dto.GameResult;
import racingcar.model.service.CarRacingGame;
import setup.TestCar;
import setup.TestCarList;

import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputViewTest extends NsTest {

    CarList testCarList;
    CarRacingGame game;
    GameResult gameResult;
    GameFactory gameFactory;
    OutputView outputView;

    static final String carName = "테스트카";
    static final int MOVING_FORWARD = 1;
    static final int STOP = 4;

    @BeforeEach
    void setUp() {
        List<Car> carList = IntStream.range(0, 3)
                .mapToObj(i -> TestCar.getTestCar(carName + i))
                .toList();
        testCarList = TestCarList.getTestCarList(carList);
        gameFactory = new GameFactory();

        gameResult = new GameResult();
        outputView = gameFactory.outputView();
        game = gameFactory.carRacingGame();
    }

    @Test
    @DisplayName("게임 결과가 성공적으로 출력되어야 한다.")
    void printResult() {
        int size = 3;
        assertRandomNumberInRangeTest(
                () -> {
                    game.play(gameResult, testCarList, size);
                    game.determineWinner(gameResult, testCarList);

                    run();
                    assertThat(output())
                            .isEqualTo("실행 결과\n" +
                                    "테스트카0 : \n" +
                                    "테스트카1 : -\n" +
                                    "테스트카2 : -\n" +
                                    "\n" +
                                    "테스트카0 : -\n" +
                                    "테스트카1 : --\n" +
                                    "테스트카2 : --\n" +
                                    "\n" +
                                    "테스트카0 : --\n" +
                                    "테스트카1 : ---\n" +
                                    "테스트카2 : ---\n" +
                                    "\n" +
                                    "최종 우승자 : 테스트카1, 테스트카2");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        outputView.printResult(gameResult);
    }
}