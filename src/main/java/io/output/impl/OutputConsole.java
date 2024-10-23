package io.output.impl;

import io.output.Output;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;
import racingcar.Cars;

public class OutputConsole implements Output {
    @Override
    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void printRoundResult(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.println(formatCarStatus(car));
        });
        System.out.println();
    }

    private String formatCarStatus(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    @Override
    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println("오류: " + message);
    }
}