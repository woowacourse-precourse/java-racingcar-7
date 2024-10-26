package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameResult;
import racingcar.model.GameRoundResult;

public class OutputView {
    public OutputView() {
    }

    public void printRoundResult(GameResult gameResult) {
        List<GameRoundResult> roundResults = gameResult.getRoundResults();

        for (GameRoundResult roundResult : roundResults) {
            //메서드 분리 해야함
            Cars cars = roundResult.getCars();
            for (Car car : cars.getCars()) {
                System.out.print(car.getName() + " : ");
                for (int i = 0; i < car.getMoveCount(); i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();

        }
    }

    public void printResultNoticeMessage() {
        System.out.println("\n실행결과");
    }

    public void printWinner(Cars winners) {
        StringJoiner winnerNames = new StringJoiner(", ");

        for (Car winner : winners.getCars()) {
            winnerNames.add(winner.getName());
        }
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
