package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import racingcar.dto.FinalResultDto;
import racingcar.dto.RoundResultDto;

public class ScoreBoard {
    private final List<Car> carList;

    public ScoreBoard(List<Car> carList) {
        this.carList = carList;
    }

    public static ScoreBoard from(List<Car> carList) {
        return new ScoreBoard(carList);
    }

    public List<RoundResultDto> returnRoundResult() {
        return carList.stream()
                .map(car -> (CarImpl) car)
                .map(RoundResultDto::from)
                .toList();
    }

    public FinalResultDto returnFinalResult() {
        int topScore = getTopScore();
        List<String> winnerList = getWinner(topScore);
        return FinalResultDto.from(winnerList);
    }

    private List<String> getWinner(int bestScore) {
        return carList.stream()
                .map(car -> (CarImpl) car)
                .filter(car -> car.checkScore(bestScore))
                .map(CarImpl::getName)
                .toList();
    }

    private int getTopScore() {
        return carList.stream()
                .map(car -> (CarImpl) car)
                .max(Comparator.comparingInt(CarImpl::getScore))
                .map(CarImpl::getScore)
                .get();
    }
}
