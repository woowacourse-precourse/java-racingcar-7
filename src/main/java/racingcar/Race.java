package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private List<Car> carList = new ArrayList<>();
    private Integer tryCount;

    IOController ioController = new IOController();

    public Race(List<String> carList, Integer tryCount) {
        for (String s : carList) {
            this.carList.add(new Car(s, new DefaultCarMoveCondition()));
        }
        this.tryCount = tryCount;
    }

    public void raceStart() {
        for (int i = 0; i < tryCount; i++) {
            executeTurn();
        }
    }

    public void executeTurn() {
        for (Car car : carList) {
            car.move();
        }
        ioController.printCurrentState(carList);
    }


    public List<String> getRaceWinners() {
        Integer longestDistance = getLongestDistance(carList);
        return carList.stream()
                .filter(car -> car.getMoveCount().length() == longestDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Integer getLongestDistance(List<Car> carList) {
        return carList.stream()
                .map(Car::getMoveCount)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }
}
