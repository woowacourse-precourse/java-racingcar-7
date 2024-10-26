package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandler {

    public void outputMessage(String message) {
        System.out.print(message);
    }

    public void outputMessageWithEmptyLine(String message) {
        outputMessage(message);
        outputEmptyLine();
    }

    public void outputEmptyLine() {
        outputMessage("\n");
    }

    public void outputCarPosition(Car car) {
        outputMessageWithEmptyLine(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void outputWinners(List<Car> winners) {
        String result = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));

        outputMessage("최종 우승자 : " + result);
    }

}