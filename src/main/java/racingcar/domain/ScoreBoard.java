package racingcar.domain;

import java.util.List;

public class ScoreBoard {
    private final List<Car> carList;

    public ScoreBoard(List<Car> carList) {
        this.carList = carList;
    }

    public static ScoreBoard from(List<Car> carList) {
        return new ScoreBoard(carList);
    }

    public List<String> returnRoundResult() {
        return carList.stream()
                .map(car -> (CarImpl) car)
                .map(this::createRoundResultForm)
                .toList();
    }

    private String createRoundResultForm(CarImpl car) {
        return car.getName() + " : " + car.toScoreSymbol();
    }
}
