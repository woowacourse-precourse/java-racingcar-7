package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameResult;
import racingcar.model.GameRoundResult;

public class OutputView {

    private static final String RUN_RESULT = "\n실행결과";
    public OutputView() {
    }

    public void printRoundResult(GameResult gameResult) {
        List<GameRoundResult> roundResults = gameResult.getRoundResults();
        roundResults.forEach(this::printSingleRoundResult);
    }

    private void printSingleRoundResult(GameRoundResult roundResult) {
        Cars cars = roundResult.getCars();
        cars.getCars().forEach(this::printCarProgress);
        System.out.println();
    }

    private void printCarProgress(Car car) {
        System.out.print(car.getName() + " : ");
        System.out.println("-".repeat(car.getMoveCount()));
    }

    public void printResultNoticeMessage() {
        System.out.println(RUN_RESULT);
    }

    public void printWinner(Cars winners) {
        StringJoiner winnerNames = new StringJoiner(", ");

        for (Car winner : winners.getCars()) {
            winnerNames.add(winner.getName());
        }
        System.out.print("최종 우승자 : " + winnerNames);
    }

    public void printErrorMessage(String message) {
        System.err.println(message);
    }
}
