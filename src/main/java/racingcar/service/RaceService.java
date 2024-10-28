package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;

public class RaceService {
    private static final int MAX_CALL_LIMIT = 1000;

    public void runRound(List<Car> cars) {
        int callCount = 0;
        for (Car car : cars) {
            if (shouldMoveForward(generateRandomDigit())) {
                car.moveForward();
            }
            callCount++;
            if (callCount > MAX_CALL_LIMIT) {
                throw new RuntimeException("Exceeded maximum call limit!");
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
