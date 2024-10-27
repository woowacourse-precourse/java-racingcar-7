package racingcar.output;

import racingcar.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandler {

    public void outputMessage(String message) {
        System.out.print(message);
    }

    public void outputMessageWithNewLine(String message) {
        outputMessage(message);
        outputNewLine();
    }

    public void outputNewLine() {
        outputMessage("\n");
    }

    public void displayCarPosition(Car car) {
        outputMessageWithNewLine(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void displayWinners(List<Car> winners) {
        String result = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        outputMessage("최종 우승자 : " + result);
    }
}