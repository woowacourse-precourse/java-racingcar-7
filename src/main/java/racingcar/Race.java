package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int FORWARD_CRITERIA = 4;
    private final List<Car> cars;
    private final RacePrinter printer = new RacePrinter();

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void startRaceNTimes(int gameCount) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            goOrStop();
            printer.printRaceStatus(cars);
        }
        printer.printFinalWinners(cars);
    }

    private void goOrStop() {
        int randomNumber;

        for (Car car : cars) {
            randomNumber = generateRandomNumber();
            if (canMove(randomNumber)) {
                car.move();
            }
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= FORWARD_CRITERIA;
    }
}
