package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames){
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void playRound(int tryCount){
        while (tryCount > 0) {
            moveCarsWithRandomCondition();

            tryCount = tryCount - 1;
            System.out.println();
        }
    }

    private void moveCarsWithRandomCondition(){
        for (Car car : cars) {
            car.moveForward();
        }
    }

}
