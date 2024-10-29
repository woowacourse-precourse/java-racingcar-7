package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void displayRoundresults(List<Car> cars) {
        for (Car car : cars) {
            car.printCarDistance();
        }
        System.out.println();
    }

    public void displayFinalResults(List<String> winnerNames) {
        System.out.println(generateResultMessage(winnerNames));
    }

    public String generateResultMessage(List<String> winnersNames) {
        return "최종 우승자 : " + String.join(", ", winnersNames);
    }
}