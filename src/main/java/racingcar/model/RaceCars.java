package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.GameConstants;
import racingcar.validate.Validation;
import racingcar.view.OutputMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RaceCars {

    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void createCars(String input) {
        Set<String> distinctCarsName = new HashSet<>();
        String[] carNames = input.split(GameConstants.COMMA);

        for (String car : carNames) {
            car = Validation.validateCreateCar(car, distinctCarsName);
            cars.add(new Car(car));
        }
    }

    public void executeRounds(int num) {
        OutputMessage.resultMessage();
        for (int i = 0; i < num; i++) {
            proceedCar();
        }
    }

    private void proceedCar() {
        for (Car car : cars) {
            car.moveCar(getRandomNumber());
            int carMoveCount = car.getMoveCount();
            OutputMessage.printHyphenMessage(car.getName(), carMoveCount);
        }
        System.out.println();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(GameConstants.RANDOM_MIN, GameConstants.RANDOM_MAX);
    }


}
