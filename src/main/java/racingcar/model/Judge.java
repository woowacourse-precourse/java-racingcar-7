package racingcar.model;

import java.util.ArrayList;

public class Judge {

    public Boolean judgeGoOrStop(Integer randomNumber) {
        return randomNumber >= 4;
    }

    public ArrayList<String> getWinners(ArrayList<Car> carList) {
        ArrayList<String> winners = new ArrayList<>();
        Long maxPosition = 0L;

        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        for (Car car : carList) {
            if (car.getPosition().equals(maxPosition)) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
