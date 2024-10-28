package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.PrintMessage;
import java.util.List;

public class GameExecutor {

    private final PrintMessage message = new PrintMessage();

    public void currentGamePlay(List<Car> cars) {
        for (Car car : cars) {
            int score = Randoms.pickNumberInRange(0, 9);
            car.setPlayGameScore(score);
            if (score > 3) {
                car.incrementGameTotalScore();
            }
            message.printCarProgress(car.getCarName(), car.getProgressDisplay());
        }
        System.out.println();
    }
}
