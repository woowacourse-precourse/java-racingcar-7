package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingServiceTest {

    private RacingService racingService;
    private OutputView outputView;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        inputView = new InputView();
        racingService = new RacingService(outputView, inputView);
    }

    @Test
    void 전체_자동차_경주_실행_테스트() {
        // given
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("pobi", 0));
        cars.add(new Car("woni", 0));
        cars.add(new Car("jun", 0));
        int tryCountNumber = 3;

        // when
        racingService.runTotalRoundRacing(cars, tryCountNumber);

        // then
        assertTrue(true);
    }

    @Test
    void 자동차_경주_우승자_찾기_테스트() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 10));
        cars.add(new Car("woni", 15));
        cars.add(new Car("jun", 15));

        Racing racing = new Racing();

        // when
        racingService.findRacingWinner(racing, cars);

        // then
        assertEquals(15, racing.getWinnerDistance());
        assertEquals(2, racing.getWinnerNames().size());
        assertTrue(racing.getWinnerNames().contains("woni"));
        assertTrue(racing.getWinnerNames().contains("jun"));
    }
}
