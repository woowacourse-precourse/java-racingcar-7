package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    final private InputController inputController;

    public CarNameValidator(InputController inputController) {
        this.inputController = inputController;
    }

    public void validate(String[] cars) {
        checkSameCarNames(cars);
        checkLengthCarNames(cars);
    }



    public String[] separateCarNames() {
        return inputController.printCarNamesInput().split(",");
    }

    public void checkLengthCarNames(String[] cars) {
        for (String carName:cars) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkSameCarNames(String[] cars) {
        Set<String> myCars = new HashSet<>(List.of(cars));
        if (cars.length != myCars.size()) {
            throw new IllegalArgumentException();
        }
    }

    public Integer changeTryTimesNumber() {
        try {
            return Integer.parseInt(inputController.printTryTimesInput());
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
