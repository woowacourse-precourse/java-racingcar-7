package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int numberOfAttempts;

    public RacingGame(List<RacingCar> cars, int numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public void startRace() {
        calculatePosition();
        findWinners();
    }

    private void calculatePosition() {
        for (int i = 0; i < this.numberOfAttempts; i++) {
            for (RacingCar car : this.cars) {
                moveCarForwardIfPossible(car);
                System.out.println(car.getName() + " : " + getDashesBasedOnPosition(car.getPosition()));
            }
            System.out.println();
        }
    }

    private void moveCarForwardIfPossible(RacingCar car) {
        if (canMoveForward()) {
            car.setPosition(car.getPosition() + 1);
        }
    }

    private boolean canMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    private String getDashesBasedOnPosition(int position) {
        return "-".repeat(position);
    }

    private void findWinners() {
        int maxPosition = 0;

        for (RacingCar car : this.cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (RacingCar car : this.cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
