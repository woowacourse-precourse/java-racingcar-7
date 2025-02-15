package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void printRaceProgress(List<Car> cars) {
        StringBuilder output = new StringBuilder();
        for (Car car : cars) {
            output.append(car.getName()).append(" : ");
            output.append("-".repeat(Math.max(0, car.getPosition())));
            output.append("\n");
        }
        output.append("\n");
        System.out.print(output);
    }
    public void printWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }
}
