package racingcar.domain;

import java.util.Comparator;
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

    private List<String> getWinner(int bestScore) {
        return carList.stream()
                .map(car -> (CarImpl) car)
                .filter(car -> car.checkScore(bestScore))
                .map(CarImpl::getName)
                .toList();
    }

    private int getTopScore() {
        int bestScore = carList.stream()
                .map(car -> (CarImpl) car)
                .max(Comparator.comparingInt(CarImpl::getScore))
                .map(CarImpl::getScore)
                .get();

        return bestScore;
    }
}
