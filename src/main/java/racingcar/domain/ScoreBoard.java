package racingcar.domain;

import static racingcar.View.constant.OutputMessage.FINAL_WINNER;

import java.util.Comparator;
import java.util.List;
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

    public String returnFinalResult() {
        int topScore = getTopScore();
        List<String> winnerList = getWinner(topScore);
        return createFinalForm(winnerList);
    }

    private String createFinalForm(List<String> winnerList) {
        String finalWinner = String.join(", ", winnerList);
        return FINAL_WINNER.getMessage() + finalWinner;
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
