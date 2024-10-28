package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CareTaker;
import racingcar.model.GameMemento;

public class OutputView {

    public void printExeResult(CareTaker careTaker) {
        System.out.println("실행 결과");
        careTaker.getAllMemento().forEach(this::printRoundResult);
    }

    private void printRoundResult(GameMemento memento) {
        memento.getCarStates().forEach(this::printCarState);
        System.out.println();
    }

    private void printCarState(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
    }

    public void printWinner(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream().map(Car::getName).toList());
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
