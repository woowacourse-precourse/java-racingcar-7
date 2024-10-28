package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.entity.Car;

public class OutputViewTest {
    @Test
    void 우승자_출력_정상적으로_표시되는지_확인() {
        OutputView outputView = new OutputView();
        List<String> winners = List.of("pobi", "jun");

        outputView.printWinners(winners);
    }

    @Test
    void 라운드_결과_자동차_진행상황이_정상적으로_표시되는지_확인() {
        OutputView outputView = new OutputView();
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        cars.get(0).move();
        cars.get(1).move();
        cars.get(1).move();
        cars.get(2).move();

        OutputView.printRoundResults(cars);
    }
}
