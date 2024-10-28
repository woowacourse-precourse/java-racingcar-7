package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final NameValidationService nameValidationService;
    private final CarList carList = new CarList(new ArrayList<>());
    private String[] carNames;

    public CarService() {
        this.nameValidationService = new NameValidationService();
    }

    public void createGame(String carNames) {
        splitCarNames(carNames);
        nameValidationService.checkForDuplicateCarNames(this.carNames);

        for (String carName : this.carNames) {
            nameValidationService.validateCarNames(carName);
            carList.addCar(new Car(carName, 0));
        }
    }

    public void splitCarNames(String carNames) {
        this.carNames = carNames.split(",");
    }

    public void playGame() {
        for (Car car : carList.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    public CarList getCarList() {
        return carList;
    }
}
