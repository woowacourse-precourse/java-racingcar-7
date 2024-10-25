package racingcar.domain;

import java.util.List;
import racingcar.exception.RaceException;
import racingcar.utility.NumberUtility;
import racingcar.utility.StringUtility;

public class Race {

    private final Cars cars;
    private final String INVALID_MOVE_COUNT_MESSAGE = "유효하지 않은 시도 횟수입니다";
    private final String RACE_DRAW_MESSAGE = "무승부";
    private final String RESULT_RACE_PREFIX = "최종 우승자 : ";
    private final int moveCount;
    private final StringBuilder raceHistoryStringBuilder = new StringBuilder();

    public Race(String moveCount, Cars cars) {
        if(!isValidMoveCount(moveCount)){
            throw new RaceException(INVALID_MOVE_COUNT_MESSAGE);
        }
        this.moveCount = NumberUtility.getNumber(moveCount);
        this.cars = cars;
    }

    private boolean isValidMoveCount(String moveCount) {
        if(!NumberUtility.isNumberStr(moveCount)){
            return false;
        }

        if(!NumberUtility.isPositiveNumber(NumberUtility.getNumber(moveCount))){
            return false;
        }
        return true;
    }

    public void doRace(){
        for (int i = 0; i < moveCount; i++) {
            cars.move();
            raceHistoryStringBuilder
                    .append(cars.formatCarsMoveHistory())
                    .append(System.lineSeparator());
        }
    }

    private String getRaceWinner() {
        List<String> winnerList = cars.getWinners();
        String raceWinner = StringUtility.listToSplitStr(winnerList);
        if(raceWinner.isEmpty()){
            raceWinner = RACE_DRAW_MESSAGE;
        }
        return raceWinner;
    }

    public String getRaceResult() {
        StringBuilder raceResultBuilder = new StringBuilder(raceHistoryStringBuilder);
        String raceWinner = getRaceWinner();
        raceResultBuilder.append(RESULT_RACE_PREFIX + raceWinner);
        return raceResultBuilder.toString();
    }
}
