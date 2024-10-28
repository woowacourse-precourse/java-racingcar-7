package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.List;

public class RaceService {
    private OutputView outputView = new OutputView();

    public void startGame(int attemptCount, List<Car> cars){
        for(int i = 0; i < attemptCount; i++){
            runRound(cars);
            outputView.displayRoundresults(cars);
        }
    }

    public void runRound(List<Car> cars){
        for (Car car : cars) {
            if (shouldMoveForward(generateRandomDigit())){
                car.moveForward();
            }
        }
    }

    public boolean shouldMoveForward(int randomDigit) {
        return randomDigit >= 4;
    }

    public int generateRandomDigit() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
