package racingcar.controller;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CalculateWinner {

    public String calculateWinner(List<Car> carList){

        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition).max().orElse(0);

        String winnerName = carList.stream().filter(car -> car.getPosition()==maxPosition)
                .map(Car::getName).collect(Collectors.joining(","));

        return winnerName;
    }
}
