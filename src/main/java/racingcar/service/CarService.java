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
            validateCarNames(carName);
            carList.addCar(new Car(carName, 0));
        }
    }

    public void splitCarNames(String carNames) {
        this.carNames = carNames.split(",");
    }

    public void validateCarNames(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void playGame() {
        for (Car car : carList.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }


}
