package racingcar.domain;

import java.util.List;

public class GameRoundHistory {

    private static final StringBuilder eachRoundResult = new StringBuilder();
    private static final StringBuilder finalResult = new StringBuilder();

    public GameRoundHistory() {
    }

    public void storeGameRoundHistory(List<Car> cars) {
        for (Car car : cars) {
            eachRoundResult
                    .append(car.getName())
                    .append(" : ")
                    .append(car.getFinalPosition(car.getPosition()))
                    .append("\n");
        }
        eachRoundResult.append("\n");
    }

}
