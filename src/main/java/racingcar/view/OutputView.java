package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameResult;

public class OutputView {
    public OutputView() {
    }

    public void printRoundResult(GameResult gameResult) {
        List<Car> carList = gameResult.getCars().getCars();

        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getMoveCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printRoundResultMessage() {
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
