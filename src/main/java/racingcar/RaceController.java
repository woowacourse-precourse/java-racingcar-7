package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RaceController {
    public void runRace(int attempts, List<Car> cars) {
        for (int i = 0; i < attempts; i++) {
            runSingleRound(cars);
            System.out.println("");
        }
    }

    private void runSingleRound(List<Car> cars) {
        for (Car car : cars) {
            attemptCarMove(car);
            System.out.println(car);
        }
    }

    private void attemptCarMove(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        System.out.println("Random Number: " + randomNumber);
        if (randomNumber >= 4) {
            car.move();
        }
    }
}
