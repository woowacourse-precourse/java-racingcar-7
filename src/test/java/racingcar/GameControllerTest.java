package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이동_테스트() {
        GameController gameController = new GameController();
        List<Car> car = List.of(new Car("pobi"), new Car("woni"));
        PrintResult printResult = new PrintResult();
        assertRandomNumberInRangeTest(
                () -> {
                    gameController.moveCars(car, 1, printResult);
                    assertThat(car.get(0).getForwardCount()).isEqualTo(1);
                    assertThat(car.get(1).getForwardCount()).isEqualTo(0);
                },
                MOVING_FORWARD, STOP
        );
    }


    @Test
    void 우승자_이름_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car pobi = new Car("pobi");
                    Car woni = new Car("woni");

                    pobi.move();

                    GameController gameController = new GameController();
                    List<Car> car = List.of(pobi, woni);
                    List<String> winner = gameController.maxCarName(car);
                    assertThat(winner).contains("pobi");

                },
                MOVING_FORWARD
        );
    }
}
