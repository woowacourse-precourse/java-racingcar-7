package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.entity.Car;

public class OutputViewTest {
    @Test
    void printWinners_ShouldDisplayCorrectly() {
        OutputView outputView = new OutputView();
        List<String> winners = List.of("pobi", "jun");

        outputView.printWinners(winners);
    }

    @Test
    void printRoundResults_ShouldDisplayCarProgress() {
        OutputView outputView = new OutputView();
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        cars.get(0).move();
        cars.get(1).move();
        cars.get(1).move();
        cars.get(2).move();

        OutputView.printRoundResults(cars);
    }
}
