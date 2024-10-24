package racingcar.io.output.impl;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarCollection;
import racingcar.io.output.Output;

public class OutputConsole implements Output {
    @Override
    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void printRoundResult(CarCollection cars) {
        List<String> carStatuses = formatAllCarStatus(cars);
        carStatuses.forEach(System.out::println);
        System.out.println();
    }

    private List<String> formatAllCarStatus(CarCollection cars) {
        List<String> statuses = new ArrayList<>();
        for (Car car : cars.cars()) {
            statuses.add(extractCarStatus(car));
        }
        return statuses;
    }

    private String extractCarStatus(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    @Override
    public void printWinners(List<Car> winners) {
        String winnerNames = formatWinnerNames(winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private String formatWinnerNames(List<Car> winners) {
        List<String> names = extractWinnerNames(winners);
        return String.join(", ", names);
    }

    private List<String> extractWinnerNames(List<Car> winners) {
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getName());
        }
        return names;
    }

    @Override
    public void close() {
        Console.close();
    }
}