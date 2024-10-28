package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;
import racingcar.View.OutputView;

import java.util.ArrayList;

public class CarService {

    public ArrayList<Car> separateCarNames(String carNames) {
        String[] cars = carNames.split(",");
        ArrayList<Car> carList = new ArrayList<>();

        for (int i = 0; i < cars.length; i++) {
            carList.add(new Car(cars[i]));
        }

        return carList;
    }
}
