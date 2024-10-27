package racingcar.model;

import java.util.ArrayList;
import java.util.List;

//레코드로 변환 고려
public class RacingGame {
    private final List<Car> carList;
    private final int num;

    public RacingGame(List<Car> cars, int num) {
        this.carList = cars;
        this.num = num;
    }


    public List<Car> getCarList() {
        return carList;
    }

    public int getNum() {
        return num;
    }

    public List<Car> getWinner() {
        int maxPosition = 0;

        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        List<Car> winners = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

}
