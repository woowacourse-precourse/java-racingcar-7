package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Car> determineWinner(List<Car> carList) {
        Collections.sort(carList, (car1, car2) -> Integer.compare(car2.getDistance(), car1.getDistance()));

        int maxDistance = carList.get(0).getDistance();

        List<Car> winnerList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getDistance() == maxDistance) {
                winnerList.add(car);
            }
        }

        return winnerList;
    }
}
