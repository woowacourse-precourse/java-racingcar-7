package racingcar.domain;

import java.util.List;

public class GameRoundHistory {

    private final StringBuilder eachRoundResult = new StringBuilder();
    private final StringBuilder finalResult = new StringBuilder();

    public GameRoundHistory() {
    }

    public void storeGameRoundHistory(List<Car> cars) {
        List<String> results = cars.stream()
                .map(car -> car.getName() + " : " + car.getFinalPosition(car.getPosition()))
                .toList();

        eachRoundResult.append(String.join("\n", results));
        eachRoundResult.append("\n");
        eachRoundResult.append("\n");
    }

    public void storeFinalWinners(List<Car> cars) {
        finalResult.append(String.join(", ", cars.stream()
                .map(Car::getName)
                .toList()));
    }

    public String getEachRoundResult() {
        return eachRoundResult.toString();
    }

    public String getFinalResult() {
        return finalResult.toString();
    }
}
