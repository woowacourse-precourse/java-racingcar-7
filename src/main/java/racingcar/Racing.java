package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Racing {

    public void start(List<Car> carList, String attemptCount) {
        for (int i = 0; i < Integer.parseInt(attemptCount.trim()); i++) {
            System.out.println();
            playRound(carList);
        }
    }

    public void playRound(List<Car> carList) {
        for (Car car : carList) {
            moveCar(car);
        }
    }

    public void moveCar(Car car) {
        if (isMovable()) {
            car.move();
            car.printCurrentPosition();
        }
    }

    public boolean isMovable() {
        return generateRandomNumber() >= 4;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
