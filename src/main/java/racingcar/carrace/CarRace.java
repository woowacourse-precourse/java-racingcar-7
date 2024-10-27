package racingcar.carrace;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;
import racingcar.utils.Parser;

public class CarRace {
    private List<Car> carList;
    private int remainNum;

    public CarRace(String cars, int num) {
        carList = Parser.parseCarList(cars);
        remainNum = num;
    }

    public void startRace() {
        while (remainNum > 0) {
            moveCar();
            remainNum--;
        }
    }

    private void moveCar() {
        for (Car car : carList) {
            if (getRandomNumber() >= 4) {
                car.move();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


}
