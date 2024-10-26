package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    private List<Car> cars;
    private int roofCount;
    OutputView outputView = new OutputView();

    public RacingGame(List<Car> cars, int roofCount) {
        this.cars = cars;
        this.roofCount = roofCount;
    }

    public void startRacing() {
        for (int i = 0; i < roofCount; i++) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4){
                    car.moveForward();
                }
            }
            outputView.printCurrentResult(cars);
        }
    }
}
