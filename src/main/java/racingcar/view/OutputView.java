package racingcar.view;

import java.util.List;
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
    }

    public void printRoundResultMessage() {
        System.out.println("실행결과");
    }
}
