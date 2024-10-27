package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void outputCustomContent(String string) {
        System.out.println(string);
    }

    public void outputCarDetails(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.makeDetail()));
        System.out.print("\n");
    }

    public void outputWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        String content = String.join(",", winnerNames);
        System.out.println("최종 우승자 : " + content);
    }
}
