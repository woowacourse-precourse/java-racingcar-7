package racingcar.service;

import racingcar.model.Car;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final OutputView outputView;

    public GameService() {
        this.outputView = new OutputView();
    }

    public void startGame(Car[] cars, int round) {
        for (int i = 0; i < round; i++) {
            playRound(cars);
        }
        endGame(cars);
    }

    private void playRound(Car[] cars) {
        outputView.executeMessage();

        for (Car car : cars) {
            int randomNumber = getRandomNumber();

            moveForward(car, randomNumber);

            outputView.roundEndMessage(car);
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void moveForward(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.forward();
        }
    }

    private void endGame(Car[] cars) {
        int maxForwardCount = 0;

        for (Car car : cars) {
            maxForwardCount = Math.max(maxForwardCount, car.getForwardCount());
        }

        List<String> winnerCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getForwardCount() == maxForwardCount) {
                winnerCars.add(car.getName());
            }
        }

        outputView.endGameMessage(winnerCars);
    }
}
