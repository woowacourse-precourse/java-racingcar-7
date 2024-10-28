package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final CarList carList = new CarList(new ArrayList<>());
    private final List<String> winners = new ArrayList<>();
    private String[] carNames;
    private int moveCount;

    public void createGame(String carNames) {
        splitCarNames(carNames);
        for (String carName : this.carNames) {
            carList.addCar(new Car(carName, 0));
        }
    }

    public void splitCarNames(String carNames) {
        this.carNames = carNames.split(",");
    }


}
