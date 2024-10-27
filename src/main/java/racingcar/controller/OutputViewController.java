package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.view.OutputView;

public class OutputViewController {
    private OutputView outputView = new OutputView();

    public void printRace(List<Car> cars) {
        for (Car car : cars) {
            outputView.printRaceProcedure(car.getName(), drewBar(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> cars) {
        String winnersName = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        outputView.printWinner(winnersName);
    }

    private String drewBar(int distance) {
        String bar = "";
        for (int i = 0; i < distance; i++) {
            bar = bar + "-";
        }
        return bar;
    }
}
