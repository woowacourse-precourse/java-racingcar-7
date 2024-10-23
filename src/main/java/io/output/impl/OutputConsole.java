package io.output.impl;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;
import racingcar.Cars;

public class OutputConsole {
    public static void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.println(formatCarStatus(car));
        });
        System.out.println();
    }

    private static String formatCarStatus(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
