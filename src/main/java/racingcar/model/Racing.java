package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.enums.Constraints;

public class Racing {
    List<RacingCar> cars;

    public Racing(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public void playTurn() {
        for (RacingCar car : cars) {
            int randomNumber = Randoms.pickNumberInRange(Constraints.MIN_MOVE_RANDOM_NUMBER_RANGE.getValue(),
                    Constraints.MAX_MOVE_RANDOM_NUMBER_RANGE.getValue());
            if (randomNumber >= Constraints.MOVE_DETERMINANT.getValue()) {
                car.moveForward();
            }
        }
    }


    public List<RacingCar> judgeWinners() {
        List<RacingCar> winners = new ArrayList<>();
        int maxPosition = 0;

        for (RacingCar car : this.cars) {
            int currentPosition = car.getCurrentPosition();

            if (currentPosition > maxPosition) {
                maxPosition = currentPosition;
                winners.clear();
                winners.add(car);
            } else if (currentPosition == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

}
