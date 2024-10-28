package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CareTaker;
import racingcar.model.GameMemento;

public class OutputView {

    public void printExeResult(CareTaker careTaker) {
        System.out.println("실행 결과");

        for (GameMemento memento : careTaker.getAllMemento()) {
            memento.getCarStates().forEach(car ->
                    System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()))
            );
            System.out.println();
        }
    }

    public void printWinner(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream().map(Car::getName).toList());
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
