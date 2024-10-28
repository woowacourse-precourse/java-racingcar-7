package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Move {

    public void moveAccordingToRandomNumber(List<Car> cars) {

        for (Car car : cars) {
            if (checkMove()) {
                car.addMoveCount();
            }
        }
    }

    public int getMaxMoveCount(List<Car> gameResult) {

        return gameResult.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElseThrow(()-> new IllegalArgumentException("입력이 비어 있습니다."));
    }

    private static boolean checkMove() {

        int randomNumber = Randoms.pickNumberInRange(0, 9);

        return randomNumber >= 4;
    }
}
