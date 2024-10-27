package racingcar.model;

import java.util.List;

public class RoundResult {
    List<Car> roundResult;

    public RoundResult(List<Car> roundResult) {
        this.roundResult = roundResult;
    }


    public List<Car> getRoundResult() {
        return roundResult;
    }

    public static RoundResult from(List<Car> roundResult) {
        return new RoundResult(roundResult);
    }
}
